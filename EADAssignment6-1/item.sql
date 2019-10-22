CREATE DATABASE Items;
use Items;

CREATE TABLE items (
id INT AUTO_INCREMENT,
title VARCHAR(50),
price DOUBLE,
imageUrl VARCHAR(100),
category VARCHAR(50),
quantity int,
primary key(id)
);

INSERT INTO items(title, price, imageUrl, category, quantity)
VALUES ('Spinach', 2.5, 'img/spinach.jpg', 'Vegetables', 0),
('Freshly Baked Bread', 3.5, 'img/bread.jpg', 'Bread', 0),
('Saffron', 4.5, 'img/saffron.jpg', 'Seasoning and Spices', 0),
('Mango', 3, 'img/mango.jpg', 'Fruits', 0),
('Butter', 5.5, 'img/butter.jpg', 'Dairy', 0);


CREATE TABLE orders (
orderId int auto_increment,
name VARCHAR(50),
Address1 VARCHAR(100),
Address2 VARCHAR(100),
City VARCHAR(100),
primary key(orderId)
);

CREATE TABLE OrderItems (
orderId int,
itemId int,
foreign key (orderId) references orders(orderId),
foreign key (itemId) references items(id)
);

select * from orders;