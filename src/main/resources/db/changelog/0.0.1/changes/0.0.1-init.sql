--liquibase formatted sql

--changeset BichikArtem:1
CREATE TABLE IF NOT EXISTS content.text
(
    id uuid constraint text_pkey primary key,
    content varchar(255),
    subscription_id int not null,
    subscription_title varchar not null,
    order_number int not null
);



CREATE TABLE IF NOT EXISTS content.word
(
    id           uuid constraint word_pkey primary key,
    ru_value     varchar(255),
    en_value     varchar(255)
);

AlTER TABLE content.word ALTER COLUMN id
    SET DEFAULT gen_random_uuid();
