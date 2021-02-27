CREATE TABLE `Citizens` (
	`citizen_id` bigint(20) NOT NULL,
	`citizen_name` varchar(200) NOT NULL,
	`zip` char(2) NOT NULL,
	`age` bigint(20) NOT NULL,
	`email` varchar(200),
	`taj` varchar(10),
	`number_of_vaccination` bigint(20),
	`last_vaccination` datetime,
	PRIMARY KEY (`citizen_id`)
);

CREATE TABLE `Vaccinations` (
	`vaccination_id` bigint(20) NOT NULL,
	`citizen_id` bigint(20) NOT NULL,
	`vaccination_date` DATETIME NOT NULL,
	`status` VARCHAR(10),
	`note` VARCHAR(200),
	`vaccination_type` VARCHAR(20),
	PRIMARY KEY (`vaccination_id`),
	CONSTRAINT `FK1` FOREIGN KEY (`citizen_id`) REFERENCES `Citizens` (`citizen_id`)
);

CREATE TABLE `Cities` (
	`city_id` bigint NOT NULL,
	`order_id` int NOT NULL,
	`shipment_date` date NOT NULL,
	PRIMARY KEY (`city_id`)
);