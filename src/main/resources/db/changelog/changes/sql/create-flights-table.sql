create table if not exists flights (
    id  serial primary key,
    date_start timestamp not null,
    date_finish timestamp not null,
    flight_status_id integer not null
        constraint flight_status_id_fk
            references flights (id),
    plane_id integer not null
        constraint flights_planes_id_fk
            references planes (id),
    route_id integer not null
        constraint flight_routes_id_fk
            references routes (id)
);