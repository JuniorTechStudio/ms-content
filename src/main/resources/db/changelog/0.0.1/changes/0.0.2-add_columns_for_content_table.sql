--liquibase formatted sql

--changeset Maxim:1
ALTER TABLE content.content
ADD COLUMN if not exists subscription_id uuid not null;

ALTER TABLE content.content
ADD COLUMN if not exists order_number int not null;