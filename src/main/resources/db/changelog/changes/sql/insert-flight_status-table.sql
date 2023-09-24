insert into flight_status
values (1, 'ПОДГОТОВКА'),
       (2, 'В ПОЛЕТЕ'),
       (3, 'ЗАВЕРШЕН'),
       (4, 'ОТМЕНА')
on conflict
    on constraint flight_status_pkey
    do update
    set id   = excluded.id,
        name = excluded.name;