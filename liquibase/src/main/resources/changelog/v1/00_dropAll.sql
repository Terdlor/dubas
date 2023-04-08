-- liquibase formatted sql

-- changeset kont:00_dropAll runOnChange:true splitStatements:true endDelimiter:/

do
$$
    BEGIN
        drop table if exists DBS_USER;
    end
$$
;
