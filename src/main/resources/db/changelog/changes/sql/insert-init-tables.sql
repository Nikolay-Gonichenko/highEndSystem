insert into documents (id, series, number, document_type_id)
values (1, 456, 789123, 1);

insert into humans (id, surname, name, last_name, birth_date, document_id)
values (1, 'Иванов', 'Иван', 'Иванович', '2002-10-10', 1);

insert into planes (id, model, passenger_count)
values (1, 'Boeing-747', 150);

insert into locations (id, country, city, airport)
values (1, 'Россия', 'Москва', 'Домодедово'), (2, 'Россия', 'Санкт-Петербург', 'Пулково');

insert into routes (id, location_from_id, location_to_id)
values (1, 1, 2);

insert into flights (id, date_start, date_finish, flight_status_id, plane_id, route_id)
values (1, '2023-09-12 12:20:00.000', '2023-09-12 14:50:00.000', 3, 1, 1);