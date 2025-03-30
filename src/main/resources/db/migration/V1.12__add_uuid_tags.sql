CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

alter table tags add column uuid uuid;

update tags set uuid = uuid_generate_v4();

alter table tags alter column uuid set not null;

alter table tags add constraint unique_uuid unique (uuid);