drop database if exists game_store_catalog;
create database game_store_catalog;
use game_store_catalog;

create table game (
    game_id int primary key auto_increment,
    title varchar(50) not null,
    esrb_rating varchar(50) not null,
    description varchar(255) not null,
    price decimal(5, 2) not null,
    studio varchar(50) not null,
    quantity int
);

create table console (
    console_id int primary key auto_increment,
    model varchar(50) not null,
    manufacturer varchar(50) not null,
    memory_amount varchar(20),
    processor varchar(20),
    price decimal(5, 2) not null,
    quantity int not null
);

create table tshirt (
    tshirt_id int primary key auto_increment,
    size varchar(20) not null,
    color varchar(20) not null,
    description varchar(255) not null,
    price decimal(5,2) not null,
    quantity int not null
);