create table if not exists banned_list (
    id   serial primary key,
    human_id integer not null
        constraint banned_list_human_fk
            references humans(id),
    reason_id integer not null
        constraint banned_list_reason_fk
            references banned_reasons(id)
);