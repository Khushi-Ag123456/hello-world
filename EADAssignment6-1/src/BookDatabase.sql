
create database books;

use books;
 
create table book(
id  int auto_increment, 
title Varchar(50),
writer Varchar(50), 
publisher Varchar(50),
published_year int,
primary key(id)
);

