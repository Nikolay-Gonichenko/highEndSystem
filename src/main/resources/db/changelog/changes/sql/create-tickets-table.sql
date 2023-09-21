create table if not exists tickets (
    id                serial primary key,
    flight_id integer      not null
        constraint tickets_flights_fk
            references flights (id),
    human_id  integer      not null
        constraint tickets_humans_fk
            references humans (id),
    cost integer not null default 0,
    place varchar(8) not null
);