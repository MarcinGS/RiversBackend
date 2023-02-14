-- liquibase formatted sql
-- changeset mgolis:2
create table region(
     id bigint not null auto_increment PRIMARY KEY,
     name varchar(255) not null
);