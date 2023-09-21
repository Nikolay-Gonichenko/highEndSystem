create table if not exists crew (
    flight_id  integer      not null
        constraint crew_flights_id
            references flights (id),
    employee_id  integer      not null
        constraint crew_employees_id
            references employees (id),
    role text not null,
    primary key (flight_id, employee_id)
);