-- liquibase formatted sql
-- changeset mgolis:4
insert into region (id, name) values(1, 'Śląsk');
update adminRiver set regionId=1;
alter table adminRiver MODIFY regionId bigint not null;