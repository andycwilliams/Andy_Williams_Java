drop database if exists pet_inventory;
create database pet_inventory;
use pet_inventory;

create table pet (
    pet_id int primary key auto_increment,
    `name` varchar(50) not null,
    birth_year int not null,
    species varchar(50) not null
);