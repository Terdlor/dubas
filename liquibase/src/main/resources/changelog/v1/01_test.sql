-- liquibase formatted sql

-- changeset kont:01_test runOnChange:true splitStatements:true endDelimiter:/

do
$$
    BEGIN
        drop table if exists test1;
        create table test1
        (
            id numeric not null ,
            dest varchar(255)
        );
    end
$$
;
