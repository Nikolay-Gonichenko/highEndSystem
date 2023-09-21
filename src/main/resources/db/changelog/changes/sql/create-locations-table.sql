create table if not exists locations (
    id            serial primary key,
    country       varchar(255) not null,
    city       varchar(255) not null,
    airport       varchar(255) not null
);