--
-- Создание промежуточной таблицы для связи тегов и пользователей
--
create table tag_user (
  id serial,
  tag_id integer,
  user_id integer,
  constraint pk_tag_user primary key (id)
);

alter table tag_user add constraint fk_tag foreign key (tag_id) references tags (id);
alter table tag_user add constraint fk_user foreign key (user_id) references users (id);

alter table tag_user add constraint uq_tag_user unique (tag_id, user_id);