-- liquibase formatted sql

-- changeset kont:01_user runOnChange:true splitStatements:true endDelimiter:/

do
$$
    BEGIN
        create table DBS_USER
        (
            DBS_USER_ID   numeric not null,
            ID            numeric not null,
            FIRST_NAME    varchar(255),
            IS_BOT        boolean,
            LAST_NAME     varchar(255),
            USER_NAME     varchar(255),
            LANGUAGE_CODE varchar(3),
            INSERT_DATE   timestamp(6) default now(),
            primary key (DBS_USER_ID)
        );

        create sequence SQ_DBS_USER_DBS_USER_ID increment 1 start with 1 cache 10;
    end
$$
;
