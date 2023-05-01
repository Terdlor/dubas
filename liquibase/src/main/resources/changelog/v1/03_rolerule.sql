-- liquibase formatted sql

-- changeset kont:03_rolerule runOnChange:true splitStatements:true endDelimiter:/

do
$$
    BEGIN
        create table RR_ROLE
        (
            RR_ROLE_ID numeric      not null,
            IS_ADMIN     boolean      default false,
            NAME         varchar(255) not null,
            INSERT_DATE  timestamp(6) default now(),
            primary key (RR_ROLE_ID)
        );

        create sequence SQ_RR_ROLE_RR_ROLE_ID increment 1 start with 1 cache 10;

        create table RR_RULE
        (
            RR_RULE_ID numeric      not null,
            KEY         varchar(255) not null,
            NAME         varchar(255) not null,
            INSERT_DATE  timestamp(6) default now(),
            primary key (RR_RULE_ID)
        );

        create sequence SQ_RR_RULE_RR_RULE_ID increment 1 start with 1 cache 10;

        create table RR_ROLE_RULE
        (
            RR_ROLE_RULE_ID numeric      not null,
            ID_ROLE    numeric      not null,
            ID_RULE    numeric      not null,
            INSERT_DATE timestamp(6) default now(),
            primary key (RR_ROLE_RULE_ID),
            constraint FK_RR_ROLE_RULE_ID_ROLE FOREIGN KEY (ID_ROLE) references RR_ROLE (RR_ROLE_ID),
            constraint FK_RR_ROLE_RULE_ID_RULE FOREIGN KEY (ID_RULE) references RR_RULE (RR_RULE_ID)
        );

        create sequence SQ_RR_ROLE_RULE_RR_ROLE_RULE_ID increment 1 start with 1 cache 10;

        alter table DBS_USER add column if not exists ROLE varchar(10);
    end
$$
;
