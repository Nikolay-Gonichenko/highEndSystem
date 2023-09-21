create table if not exists options (
    id            serial primary key,
    option_type_id integer      not null
        constraint options_type_fk
            references option_type (id),
    ticket_id integer not null
        constraint options_tickets_fk
            references tickets (id)
);