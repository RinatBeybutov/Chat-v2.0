--
-- Добавление пароля для таблицы users
--
alter table users add column password text default '123' not null;