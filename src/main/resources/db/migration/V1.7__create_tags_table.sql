--
-- Создание таблицы тегов
--
create table tags (
  id serial,
  name varchar(255),
  constraint pk_tags primary key (id)
);