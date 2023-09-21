create table if not exists banned_reasons (
    id   serial primary key,
    name text not null
);