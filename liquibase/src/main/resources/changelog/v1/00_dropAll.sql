-- liquibase formatted sql

-- changeset kont:00_dropAll runOnChange:true splitStatements:true endDelimiter:/

do
$$
    BEGIN
        drop table if exists DBS_USER;
        drop sequence if exists SQ_DBS_USER_DBS_USER_ID;
    end
$$
;
