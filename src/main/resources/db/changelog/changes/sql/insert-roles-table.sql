insert into roles (id, name)
values (1, 'ПОЛЬЗОВАТЕЛЬ'),
       (2, 'АДМИНИСТРАТОР'),
       (3, 'РАБОТНИК'),
       (4, 'МЕНЕДЖЕР')
on conflict
    on constraint roles_pkey
    do update
    set id   = excluded.id,
        name = excluded.name;