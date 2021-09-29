create table if not exists actor (
id bigserial primary key,
name text not null,
movie bigint references movie(id),
unique (name, movie)
);

-- two actors cannot have the same name and two movies cannot have the name