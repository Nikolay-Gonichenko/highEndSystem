create table if not exists routes (
    id   serial primary key,
    location_from_id integer not null
        constraint routes_locations_from_fk
            references locations (id),
    location_to_id integer not null
        constraint routes_locations_to_fk
            references locations (id)
);