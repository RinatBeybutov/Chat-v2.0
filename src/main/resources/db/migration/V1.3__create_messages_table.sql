create table messages (
  id serial,
  message text,
  created_at timestamp,
  user_id integer references users(id),
  constraint pk_messages primary key (id)
);