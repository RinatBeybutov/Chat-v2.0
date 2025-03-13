--
-- Вставка данных в таблицу `cities`
--
insert into cities (id, name, phone_code)
values (1, 'Moscow', '495'),
(2, 'Краснодар', '861'),
(3, 'Казань','843');

--
-- Установка последнего id для автоинкремента
--
select setval('cities_id_seq', 3, true);

--
-- Установка всем пользователям город Москва (по умолчанию)
--
update users set city_id = 1;

--
-- Добавление ограничения not null для столбца city_id
--
alter table users alter column city_id set not null;

--
-- Добавление внешнего ключа для столбца city_id в таблице users
--
alter table users add constraint fk_users_city_id foreign key (city_id) references cities (id);