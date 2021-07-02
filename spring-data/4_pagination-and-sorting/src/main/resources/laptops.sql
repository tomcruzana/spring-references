create database laptops_db;

use laptops_db;

create table laptops(
	id int primary key auto_increment,
    brand varchar(50),
    name varchar(50),
    model varchar(50),
    serial varchar(50),
    quantity int,
    price decimal
);

select * from laptops;

delete from laptops where id = 1;

drop table laptops;