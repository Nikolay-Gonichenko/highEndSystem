insert into banned_reasons (id, name)
values (1, 'Превышено количество нарушений'),
       (2, 'Угроза жизни и/или здоровью других людей во время полёта')
on conflict
    on constraint banned_reasons_pkey
    do update
    set id   = excluded.id,
        name = excluded.name;