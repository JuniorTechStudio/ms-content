--liquibase formatted sql

--changeset Pavlik:1
CREATE SCHEMA content
CREATE TABLE IF NOT EXISTS content.content
(
    id uuid not null
    constraint content_pkey primary key,
    content varchar(255)
);