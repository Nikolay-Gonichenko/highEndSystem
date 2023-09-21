create table if not exists positions (
    id            serial primary key,
    name       varchar(255) not null,
    department_id integer not null
        constraint positions_departments_fk
            references departments (id)
);