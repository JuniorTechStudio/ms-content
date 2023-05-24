--liquibase formatted sql
--changeset BichikArtem:6

AlTER TABLE content.word ALTER COLUMN id
    SET DEFAULT gen_random_uuid();