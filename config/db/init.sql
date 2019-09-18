create table customers
(
    id serial not null
        constraint table_name_pk
            primary key,
    first_name varchar(45),
    last_name varchar(45),
    email varchar(45)
);

create unique index table_name_id_uindex
    on customers (id);

ALTER SEQUENCE customers_id_seq RESTART WITH 6;