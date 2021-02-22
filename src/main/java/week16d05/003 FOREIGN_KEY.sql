-- PRIMARY KEY

-- TRUNCATE
-- TRUNCATE [TABLE] tbl_name || TRUNCATE TABLE empties a table completely.
-- Any AUTO_INCREMENT value is reset to its start value.

-- FORREIGN KEY

-- CREATE TABLE child_table
-- (
--   column1 datatype [ NULL | NOT NULL ],
--   column2 datatype [ NULL | NOT NULL ],
--   ...
-- 
--   CONSTRAINT fk_name
--     FOREIGN KEY (child_col1, child_col2, ... child_col_n)
--     REFERENCES parent_table (parent_col1, parent_col2, ... parent_col_n)
--     ON DELETE CASCADE
--     [ ON UPDATE { NO ACTION | CASCADE | SET NULL | SET DEFAULT } ] 
-- );


-- Összetett kulcsok mind a két kategóriára
CREATE DATABASE notes;

USE notes;

CREATE TABLE `clients` (
	`client_id` INT NOT NULL PRIMARY KEY,
	`client_name` VARCHAR(30) NOT NULL,
	`client_contact` VARCHAR(50) NOT NULL
);

INSERT INTO `clients` VALUES(9999, 'DELETED', 'DELETED')

CREATE TABLE `tasks` (
	`task_id` INT NOT NULL PRIMARY KEY,
	`client_id` INT,
	`task_name` VARCHAR(50) NOT NULL,
	FOREIGN KEY (`client_id`) 
		REFERENCES clients(`client_id`)
		  ON DELETE SET NULL
		  ON UPDATE SET NULL
);

SELECT * FROM `tasks`;

DESCRIBE `tasks`;

INSERT INTO `clients` VALUES(1, 'Tamas', 'Tamascon')

INSERT INTO `tasks` VALUES(1, 1, 'Tasks')

SELECT * FROM `notes`;

DELETE FROM `clients` WHERE `client_id` = 1;

CREATE TABLE `notes` (
   `note_id` INT NOT NULL PRIMARY KEY,
	`task_id` INT,
	`note_text` VARCHAR(50) NOT NULL,
	FOREIGN KEY (`task_id`) 
		REFERENCES `tasks` (`task_id`)
			ON DELETE SET NULL
);

INSERT INTO `notes` VALUES(1, 1, 'text')