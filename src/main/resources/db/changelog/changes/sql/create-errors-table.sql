create table if not exists errors (
    id   serial primary key,
    error_type_id integer not null
        constraint errors_error_type_fk
            references error_type(id),
    message text not null
);