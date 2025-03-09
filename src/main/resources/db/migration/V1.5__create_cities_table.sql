create table cities (
  id serial,
  name varchar(255),
  phone_code varchar(255),
  constraint pk_cities primary key (id)
);

alter table users add column city_id integer;