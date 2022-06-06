drop database if exists game_store_invoicing;
create database game_store_invoicing;
use game_store_invoicing;

create table invoice (
    invoice_id int primary key auto_increment,
    `name` varchar(50) not null,
    street varchar(100) null,
    city varchar(50) not null,
    state varchar(20) not null,
    zipcode varchar(10) null,
    item_type varchar(50) not null,
    item_id int not null, -- links to either game, console, or t_shirt ids
    unit_price decimal(8,2) not null,
    quantity int not null,
    subtotal decimal(8,2) not null,
    tax decimal(8,2) not null,
    processing_fee decimal(8,2) not null,
    total decimal(8,2) not null
);

create table fee (
    product_type varchar(50) primary key,
    fee decimal(8,2) not null
);

create table tax (
    state char(2) primary key,
    rate decimal(8,2) not null
);
