create table if not exists planes (
    id   serial primary key,
    model varchar(255) not null,
    passenger_count integer not null
);