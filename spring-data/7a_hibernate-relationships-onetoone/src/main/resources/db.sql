create database driver_license_db;

use driver_license_db;

create table person (
	id int primary key auto_increment,
	fname varchar(30),
    lname varchar(30),
    age int
);

create table license (
	license_number int primary key,
    person_id int,
    foreign key (person_id) references person(id)
);

insert into person values (1, "jimmy", "johns", 27);
insert into license values (123456789, 1);

select * from person inner join license on person.id = license.person_id;

drop database driver_license_db;