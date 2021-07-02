create database vehicles_db;

use vehicles_db;

create table ground_vehicle(
	id int primary key,
    model varchar(30),
    make varchar(30),
    brand varchar(30),
    color varchar(30)
);

ALTER TABLE ground_vehicle ADD wheels int;

ALTER TABLE ground_vehicle MODIFY id int NOT NULL AUTO_INCREMENT;

create table car(
	id int,
    price decimal(6,2),
    foreign key (id) references ground_vehicle(id) on delete cascade
);

select * from ground_vehicle;
select * from car;

select * from ground_vehicle inner join car
on ground_vehicle.id = car.id;

drop table ground_vehicle ;
drop table car;

drop database vehicles_db;
