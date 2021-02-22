CREATE DATABASE notes;
USE notes;
CREATE TABLE `clients` (
	`client_id` INT NOT NULL PRIMARY KEY,
	`client_name` VARCHAR(30) NOT NULL,
	`client_contact` VARCHAR(50) NOT NULL
);
CREATE TABLE `tasks` (
	`task_id` INT NOT NULL PRIMARY KEY,
	`client_id` INT NOT NULL,
	`task_name` VARCHAR(50) NOT NULL
);
CREATE TABLE `notes` (
   `note_id` INT NOT NULL PRIMARY KEY,
	`task_id` INT NOT NULL,
	`note_text` VARCHAR(50) NOT NULL
);
