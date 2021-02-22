-- kényszerek UNIQUE, PRIMARY KEY
/*
CREATE TABLE table_name(
   ...,
   column_name data_type UNIQUE,
   ...
);*/

/*
CREATE TABLE table_name(
   ...
   column_name1 column_definition,
   column_name2 column_definition,
   ...,
   UNIQUE(column_name1,column_name2)
);
*/

CREATE DATABASE `logistics`;
USE `logistics`;
-- abcsdf123ae312-sf21sd-sdf12sdff
CREATE TABLE `suppliers` (
    `supplier_id` INT AUTO_INCREMENT,
	 `name` VARCHAR(255) NOT NULL,
    `phone` VARCHAR(15) NOT NULL UNIQUE,
    `address` VARCHAR(255) NOT NULL,
    PRIMARY KEY(`supplier_id`)
);

DESCRIBE `suppliers`;

INSERT INTO `suppliers` (`name`, `phone`, `address`) VALUES('Tamas', 55535, 'Cim');

SELECT * FROM `suppliers`;

DROP TABLE `suppliers`;

-- The following constraints are commonly used in SQL:

-- NOT NULL - Ensures that a column cannot have a NULL value
-- UNIQUE - Ensures that all values in a column are different
-- PRIMARY KEY - A combination of a NOT NULL and UNIQUE. Uniquely identifies each row in a table
-- FOREIGN KEY - Uniquely identifies a row/record in another table
-- CHECK - Ensures that all values in a column satisfies a specific condition
-- DEFAULT - Sets a default value for a column when no value is specified
-- INDEX - Used to create and retrieve data from the database very quickly

-- AUTO INCREMENT és annak módosítása (ALTER TABLE AUTO_INCREMENT)