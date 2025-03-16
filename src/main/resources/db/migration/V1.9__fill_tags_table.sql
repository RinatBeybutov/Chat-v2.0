--
-- Заполнение таблицы "tags" данными
--
insert into tags(id, name)
values(1, 'Геймер'),
(2, 'Собачник'),
(3, 'Писатель'),
(4, 'Спорт'),
(5, 'Путешествия');

select setval('tags_id_seq', 5, true);