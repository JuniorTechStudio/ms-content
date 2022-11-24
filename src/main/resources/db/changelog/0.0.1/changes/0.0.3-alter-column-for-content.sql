--liquibase formatted sql

--changeset Pavlik:2
ALTER TABLE content.content
RENAME COLUMN subscription_id TO subscription_title;
ALTER TABLE content.content
ALTER COLUMN subscription_title TYPE varchar;