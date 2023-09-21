create table if not exists humans (
    id   serial primary key,
    surname varchar(255) not null,
    name varchar(255) not null,
    last_name varchar(255),
    birth_date timestamp not null,
    document_id integer not null
        constraint humans_documents_fk
            references documents(id)
);