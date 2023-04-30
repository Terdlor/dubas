-- liquibase formatted sql

-- changeset kont:00_dropAll runOnChange:true splitStatements:true endDelimiter:/

do
$$
    BEGIN
        drop table if exists DBS_USER;
        drop table if exists DBS_BRAND;
        drop table if exists DBS_LINE;
        drop table if exists DBS_TAG;
        drop table if exists DBS_TOBACCO;
        drop table if exists DBS_TOBACCO_TAG;
        drop sequence if exists SQ_DBS_USER_DBS_USER_ID;
        drop sequence if exists SQ_DBS_BRAND_DBS_BRAND_ID;
        drop sequence if exists SQ_DBS_LINE_DBS_LINE_ID;
        drop sequence if exists SQ_DBS_TAG_DBS_TAG_ID;
        drop sequence if exists SQ_DBS_TOBACCO_DBS_TOBACCO_ID;
        drop sequence if exists SQ_DBS_TOBACCO_TAG_DBS_TOBACCO_TAG_ID;

        drop table if exists RR_ROLE;
        drop table if exists RR_RULE;
        drop table if exists RR_ROLE_RULE;
        drop sequence if exists SQ_RR_ROLE_RR_ROLE_ID;
        drop sequence if exists SQ_RR_RULE_RR_RULE_ID;
        drop sequence if exists SQ_RR_ROLE_RULE_RR_ROLE_RULE_ID;
    end
$$
;
