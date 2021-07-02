create database sales_db;

use sales_db;

create table salesman (
	id int primary key auto_increment,
	fname varchar(30),
    lname varchar(30),
    sales_count int
);

create table customer (
	id int primary key auto_increment,
    fname varchar(30),
    lname varchar(30)
);

create table orders(
	customer_id int,
    salesman_id int,
    foreign key (customer_id) references customer (id),
    foreign key (salesman_id) references salesman (id)
);

select * from salesman;
select * from customer;
select * from orders;

drop database sales_db;