create table if not exists accounts (
    id                serial primary key,
    nickname          varchar(255) not null,
    password          varchar(255) not null,
    human_id          integer      not null
        constraint accounts_humans_id
            references humans (id),
    bonus_money       integer      not null default 0,
    registration_date timestamp    not null,
    violation_count   integer      not null default 0,
    role_id           integer      not null
        constraint accounts_roles_fk
            references roles (id)
);