-- liquibase formatted sql
-- changeset mgolis:2
alter table adminriver add image varchar(128) after growDate;
