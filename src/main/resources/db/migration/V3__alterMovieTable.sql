alter table if exists movie
add column if not exists actors bigint references actor(id);