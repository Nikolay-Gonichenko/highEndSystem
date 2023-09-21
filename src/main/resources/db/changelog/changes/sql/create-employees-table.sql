create table if not exists employees (
    id                serial primary key,
    account_id integer not null
        constraint employees_accounts_fk
            references accounts(id),
    employment_date timestamp not null,
    position_id integer not null
        constraint employees_positions_fk
            references positions(id),
    salary integer not null default 0
);