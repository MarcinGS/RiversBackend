-- liquibase formatted sql
-- changeset mgolis:3
alter table adminRiver add regionId bigint after riverName;
alter table adminRiver drop column region;
alter table adminRiver add constraint fk_riverAdmin_region_id foreign key (regionId) references region(id);