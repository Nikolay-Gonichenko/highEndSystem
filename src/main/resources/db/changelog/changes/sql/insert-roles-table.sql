insert into roles (id, name)
values (1, 'USER'),
       (2, 'ADMIN'),
       (3, 'EMPLOYEE'),
       (4, 'MANAGER')
on conflict
    on constraint roles_pkey
    do update
    set id   = excluded.id,
        name = excluded.name;