create table if not exists documents (
    id   serial primary key,
    series integer not null,
    number integer not null,
    document_type_id integer not null
        constraint document_type_fk
            references document_type(id)
);