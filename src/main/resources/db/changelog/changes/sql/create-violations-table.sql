create table if not exists violations (
    id   serial primary key,
    account_id integer not null
        constraint violations_accounts_fk
            references accounts(id),
    violation_type_id integer not null
        constraint violation_type_fk
            references violation_type(id),
    date timestamp not null,
    message text not null
);