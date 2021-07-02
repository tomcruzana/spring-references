create database person_db;

use person_db;

create table person(
	id int primary key,
    fname varchar(30),
    lname varchar(30)
);

create table developer(
	id int primary key,
    fname varchar(30),
    lname varchar(30),
    title varchar(30)
);

create table humanoid(
	id int primary key,
    fname varchar(30),
    lname varchar(30),
    hp int
);

drop database person_db;
select * from humanoid;
select * from developer;