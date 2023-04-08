-- liquibase formatted sql

-- changeset kont:01_user runOnChange:true splitStatements:true endDelimiter:/

do
$$
    BEGIN
        create table DBS_USER
        (
            id            numeric not null,
            first_name    varchar(255),
            is_bot        boolean,
            last_name     varchar(255),
            user_name     varchar(255),
            language_code varchar(3)
        );
    end
$$
;
