CREATE TABLE `citizens` (
	`citizen_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
	`citizen_name` VARCHAR(200) NOT NULL,
	`zip_code` int(4) unsigned NOT NULL,
	`age` int(3) unsigned NOT NULL,
	`email` VARCHAR(200) NOT NULL,
	`medical_record` CHAR(9) NOT NULL,
	`number_of_vaccination` int(1) unsigned NOT NULL DEFAULT '0',
	`last_vaccination` date NULL,
	PRIMARY KEY (`citizen_id`)
);

CREATE TABLE `vaccinations` (
	`vaccination_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
	`citizen_id` int(10) unsigned NOT NULL,
	`vaccination_date` datetime NOT NULL,
	`status` varchar(10),
	`note` varchar(200),
	`vaccination_type` varchar(20),
	PRIMARY KEY (`vaccination_id`),
	CONSTRAINT `FK_vaccinations_to_citizens` FOREIGN KEY (`citizen_id`) REFERENCES `citizens` (`citizen_id`)
);

CREATE TABLE `zip_codes` (
	`zip_code` int(4) unsigned NOT NULL,
	`city` varchar(23) NOT NULL,
	`district` varchar(26)
);
