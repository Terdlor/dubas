-- liquibase formatted sql

-- changeset kont:02_dubas runOnChange:true splitStatements:true endDelimiter:/

do
$$
    BEGIN
        create table DBS_BRAND
        (
            DBS_BRAND_ID numeric      not null,
            NAME         varchar(255) not null,
            HAS_LINE     boolean      default false,
            INSERT_DATE  timestamp(6) default now(),
            primary key (DBS_BRAND_ID)
        );

        create sequence SQ_DBS_BRAND_DBS_BRAND_ID increment 1 start with 1 cache 10;

        create table DBS_LINE
        (
            DBS_LINE_ID numeric      not null,
            ID_BRAND    numeric      not null,
            NAME        varchar(255) not null,
            INSERT_DATE timestamp(6) default now(),
            primary key (DBS_LINE_ID),
            constraint FK_DBS_BRAND FOREIGN KEY (ID_BRAND) references DBS_BRAND (DBS_BRAND_ID)
        );

        create sequence SQ_DBS_LINE_DBS_LINE_ID increment 1 start with 1 cache 10;

        create table DBS_TAG
        (
            DBS_TAG_ID  numeric      not null,
            NAME        varchar(255) not null,
            INSERT_DATE timestamp(6) default now(),
            primary key (DBS_TAG_ID)
        );

        create sequence SQ_DBS_TAG_DBS_TAG_ID increment 1 start with 1 cache 10;

        create table DBS_TOBACCO
        (
            DBS_TOBACCO_ID numeric      not null,
            ID_BRAND       numeric      not null,
            ID_LINE        numeric      not null,
            NAME           varchar(255) not null,
            INSERT_DATE    timestamp(6) default now(),
            primary key (DBS_TOBACCO_ID),
            constraint FK_DBS_LINE FOREIGN KEY (ID_LINE) references DBS_LINE (DBS_LINE_ID)
        );

        create sequence SQ_DBS_TOBACCO_DBS_TOBACCO_ID increment 1 start with 1 cache 10;

        create table DBS_TOBACCO_TAG
        (
            DBS_TOBACCO_TAG_ID numeric not null,
            ID_TAG             numeric not null,
            ID_TOBACCO         numeric not null,
            INSERT_DATE        timestamp(6) default now(),
            primary key (DBS_TOBACCO_TAG_ID),
            constraint FK_DBS_TOBACCO FOREIGN KEY (ID_TOBACCO) references DBS_TOBACCO (DBS_TOBACCO_ID),
            constraint FK_DBS_TAG FOREIGN KEY (ID_TAG) references DBS_TAG (DBS_TAG_ID)
        );

        create sequence SQ_DBS_TOBACCO_TAG_DBS_TOBACCO_TAG_ID increment 1 start with 1 cache 10;
    end
$$
;
