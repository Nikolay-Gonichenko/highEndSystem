insert into error_type (id, name)
values (1, 'Ошибка в работе сервиса уровня сущности'),
       (2, 'Ошибка в работе сервиса менеджера'),
       (3, 'Ошибка в работе сервиса администратора'),
       (4, 'Ошибка в работе сервиса работника'),
       (5, 'Ошибка в работе сервиса клиента')
on conflict
    on constraint error_type_pkey
    do update
    set id   = excluded.id,
        name = excluded.name;