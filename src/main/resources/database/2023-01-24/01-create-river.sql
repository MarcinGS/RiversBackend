-- liquibase formatted sql
-- changeset mgolis:1
create table adminriver (
    id bigint not null auto_increment PRIMARY KEY,
    stationId bigint not null,
    stationName varchar(255),
    riverName varchar(255),
    region varchar(255),
    waterLevel double,
    waterDate datetime,
    waterTemp double,
    tempDate datetime,
    iceLevel double,
    iceDate datetime,
    growLevel double,
    growDate datetime,
    image varchar(128)
);

create table userriver (
   id bigint not null auto_increment PRIMARY KEY,
   stationId bigint not null,
   stationName varchar(255),
   riverName varchar(255),
   region varchar(255),
   waterLevel double,
   waterDate datetime,
   waterTemp double,
   tempDate datetime,
   iceLevel double,
   iceDate datetime,
   growLevel double,
   growDate datetime,
   note longtext,
   image varchar(128)
);