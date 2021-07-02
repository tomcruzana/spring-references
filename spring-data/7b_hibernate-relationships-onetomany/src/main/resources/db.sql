create database skateboard_db;

use skateboard_db;

create table skater (
	id int primary key auto_increment,
	fname varchar(30),
    lname varchar(30),
    age int
);

create table skateboard (
	id int primary key,
    brand varchar(30),
    skater_id int,
    foreign key (skater_id) references skater(id)
);

insert into skater (fname, lname, age) values ("jay", "manx", 27);
insert into skater (fname, lname, age) values ("tom", "cruze", 26);
insert into skater (fname, lname, age) values ("harold", "reyz", 25);

insert into skateboard (id, brand) values (100, "blind");
insert into skateboard (id, brand) values (200, "toy machine");
insert into skateboard (id, brand) values (300, "zero");
insert into skateboard (id, brand) values (400, "plan b");
insert into skateboard (id, brand) values (500, "baker");

select * from skater;
select * from skater inner join skateboard on skater.id = skateboard.skater_id;

drop database skateboard_db;