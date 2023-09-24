insert into violation_type (id, name)
values (1, 'ДИСЦИПЛИНА'),
       (2, 'ТЕХНИКА_БЕЗОПАСНОСТИ'),
       (3, 'ПРОФНАРУШЕНИЕ')
on conflict
    on constraint violation_type_pkey
    do update
    set id   = excluded.id,
        name = excluded.name;