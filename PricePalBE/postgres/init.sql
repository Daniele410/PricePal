create table item(
    id serial primary key,
    name varchar(100) not null,
    price decimal(10, 2) not null,
    supermarket varchar(100) not null,
    notes text
)