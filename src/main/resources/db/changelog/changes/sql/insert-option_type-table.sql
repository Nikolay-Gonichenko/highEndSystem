insert into option_type (id, name)
values (1, 'Дополнительный багаж'),
       (2, 'Премиум класс'),
       (3, 'Двойная порция еды'),
       (4, 'Негабаритный багаж')
on conflict
    on constraint option_type_pkey
    do update
    set id   = excluded.id,
        name = excluded.name;