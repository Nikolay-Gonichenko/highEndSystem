insert into document_type
values (1, 'ПАСПОРТ'),
       (2, 'ЗАГРАНПАСПОРТ')
on conflict
    on constraint  document_type_pkey
    do update
    set id   = excluded.id,
        name = excluded.name;