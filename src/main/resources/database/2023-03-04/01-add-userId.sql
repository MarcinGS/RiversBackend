--liquibase formatted sql
--changeset mgolis:5
    alter table `userlist` add userId bigint;
--changeset mgolis:6
    alter table `userlist` add constraint fk_userlist_user_id foreign key (userId) references users(id);