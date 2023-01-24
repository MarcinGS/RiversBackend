--liquibase formatted sql
--changeset mgolis:1
create table river (
    id bigint not null auto_increment PRIMARY KEY,
    stationId bigint not null,
    stationName varchar(255),
    riverName varchar(255),
    region varchar(255),
    waterLevel int,
    waterDate datetime,
    waterTemp int,
    tempDate datetime,
    iceLevel int,
    iceDate datetime,
    growLevel int,
    growDate datetime
);