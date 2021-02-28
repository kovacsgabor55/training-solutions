CREATE TABLE `Citizens` (
	`citizen_id` int(10) NOT NULL AUTO_INCREMENT,
	`citizen_name` varchar(200) NOT NULL,
	`zip` int(4) NOT NULL,
	`age` int(3) NOT NULL,
	`email` varchar(200) NOT NULL,
	`taj` char(9) NOT NULL,
	`number_of_vaccination` int(1) DEFAULT 0,
	`last_vaccination` datetime,
	PRIMARY KEY (`citizen_id`)
);

CREATE TABLE `Vaccinations` (
	`vaccination_id` int(10) NOT NULL AUTO_INCREMENT,
	`citizen_id` int(10) NOT NULL,
	`vaccination_date` datetime NOT NULL,
	`status` varchar(10),
	`note` varchar(200),
	`vaccination_type` varchar(20),
	PRIMARY KEY (`vaccination_id`),
	CONSTRAINT `FK1` FOREIGN KEY (`citizen_id`) REFERENCES `Citizens` (`citizen_id`)
);

CREATE TABLE `Cities` (
	`city_id` bigint NOT NULL AUTO_INCREMENT,
	`order_id` int NOT NULL,
	`shipment_date` date NOT NULL,
	PRIMARY KEY (`city_id`)
);