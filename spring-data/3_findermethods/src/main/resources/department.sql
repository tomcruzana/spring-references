create database departments_db;

use departments_db;

create table department(
	id int primary key auto_increment,
    name varchar(50),
    enrolled_students int,
    tuition decimal
);

select * from department;

select name, enrolled_students from department where enrolled_students > 45;

select name from department where id in(5,9,7);

drop table department;