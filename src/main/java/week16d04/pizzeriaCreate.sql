CREATE DATABASE `pizzeria`;
USE `pizzeria`;

CREATE TABLE `pizza` (
	`pizza_id` INT NOT NULL,
	`pizza_name` VARCHAR(100) NULL DEFAULT NULL,
	`pizza_price` FLOAT NULL DEFAULT NULL,
	PRIMARY KEY (`pizza_id`)
)
COLLATE='utf8_general_ci'
;

CREATE TABLE `customers` (
	`customer_id` INT NOT NULL,
	`customer_name` VARCHAR(100) NULL DEFAULT NULL,
	PRIMARY KEY (`customer_id`)
)
COLLATE='utf8_general_ci'
;

CREATE TABLE `order` (
	`order_id` INT NOT NULL,
	`customer_id` INT NOT NULL,
	`pizza_id` INT NOT NULL,
	`order_date` DATE NULL,
	PRIMARY KEY (`order_id`),
	CONSTRAINT `FK_order_to_pizza` FOREIGN KEY (`pizza_id`) REFERENCES `pizza` (`pizza_id`),
	CONSTRAINT `FK_order_to_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
)
COLLATE='utf8_general_ci'
;

INSERT INTO pizza VALUES (1,'pepperoni',960),
(2,'mascarpone',1200),
(3,'hawai',1500),
(4,'magyaros',800),
(5,'salame',3000),
(6,'mozzarella',1200),
(7,'vegane',1400),
(8,'spencer',1520),
(9,'chili',890),
(10,'chicken',1000);

INSERT INTO customers VALUES (1,'Géza'),
(2,'Gusztáv'),
(3,'Arnold'),
(4,'Kristóf'),
(5,'István'),
(6,'László'),
(7,'Tamás'),
(8,'József'),
(9,'Béla'),
(10,'Károly');

INSERT INTO `order` VALUES (1,5,7,'2020-8-12'),
(2,3,6,'2019-11-30'),
(3,7,2,'2020-9-6'),
(4,10,1,'2020-11-15'),
(5,2,4,'2021-5-18'),
(6,9,9,'2020-6-24'),
(7,4,3,'2019-12-14'),
(8,6,8,'2021-11-15'),
(9,8,5,'2020-5-13'),
(10,1,10,'2020-6-8');
