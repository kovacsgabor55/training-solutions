/*
 azon azonosito ami egyedileg azonsitja a befizetot SZAM
 datum eeee.ho.nap. oo:pp:mm
 osszeg SZAM
*/
CREATE DATABASE `tagdij`;
USE `tagdij`;
CREATE TABLE `befiz` (
	`azon` INT(10) UNSIGNED NOT NULL,
	`datum` DATETIME NOT NULL,
	`osszeg` INT(10) UNSIGNED NOT NULL,
	`ugyfel_azon` INT(10) UNSIGNED NOT NULL
);
DROP TABLE `befiz`;
SELECT * FROM `befiz`;
ALTER TABLE `befiz` ADD `ugyfel_azon` INT(10) UNSIGNED NOT NULL;
INSERT INTO `befiz` VALUES (1001, '2010.12.05 16:15:25', 60000, 9001); /*Otto*/
INSERT INTO `befiz` VALUES (1002, '2010.12.05 16:15:25', 5000, 9001);  /*Otto*/
INSERT INTO `befiz` VALUES (1003, '2010.12.06 16:15:25', 6000, 9002);  /*Agi*/
INSERT INTO `befiz` VALUES (1004, '2010.12.08 16:00:25', 160000, 9006); /*Marci*/
INSERT INTO `befiz` VALUES (1005, '2010.12.07 16:15:25', 6000, 9004); /*Peter*/
DELETE * FROM `befiz` WHERE 1;
UPDATE `befiz` SET `ugyfel_azon` = 9001 WHERE `azon` = 1001 OR `azon` = 1002;
CREATE TABLE `ugyfel` (
	`azon` INT(10) UNSIGNED NOT NULL,
	`nev` VARCHAR(30) NOT NULL
);
INSERT INTO `ugyfel` VALUES (9001, 'Otto');
INSERT INTO `ugyfel` VALUES (9002, 'Agi');
INSERT INTO `ugyfel` VALUES (9004, 'Peter');
INSERT INTO `ugyfel` VALUES (9005, 'Tamas');
INSERT INTO `ugyfel` VALUES (9006, 'Marci');
/*
1001, 'Otto'
1002, 'Agi'
1003, 'Tamas'
*/
/*DELETE FROM `tagdij`.`befiz` WHERE  `azon`=1001 AND `datum`='2010-12-05 16:15:25' AND `osszeg`=60000 LIMIT 1;*/
/*DELETE FROM `befiz` WHERE 1;*/
/*
USE `test`;
DROP TABLE `befiz`;
*/
/*
`azonosito`
'adat'
*/
/* ugyfel
	azon egyedi azonositja a befizetot SZAM 10
	nev STRING 30
*/
SELECT * FROM `befiz`;
SELECT `azon`, `osszeg` FROM `befiz`;
SELECT `azon`, `osszeg` FROM `befiz` WHERE `osszeg` > 10000;
SELECT * FROM `befiz` WHERE `osszeg` < 10000;
/*Lekerdesezhez hasznos fuggvenyek*/
SELECT COUNT(azon) FROM `befiz` WHERE `osszeg` < 10000;
SELECT SUM(osszeg) FROM `befiz` WHERE `osszeg` < 10000;
SELECT AVG(osszeg) FROM `befiz` WHERE `osszeg` < 10000;
SELECT MAX(osszeg) FROM `befiz` WHERE `osszeg` < 10000;
SELECT MIN(osszeg) FROM `befiz` WHERE `osszeg` < 10000;
SELECT * FROM `befiz` WHERE `osszeg` < 10000 AND `azon` <= 1003;
SELECT * FROM `befiz` WHERE `osszeg` < 10000 OR `azon` <= 1003;
SELECT * FROM `befiz` ORDER BY `datum` DESC;
SELECT * FROM `befiz` GROUP BY `datum` ORDER BY `datum` DESC;
SELECT * FROM `befiz` WHERE `osszeg` < 10000 GROUP BY `osszeg`;
SELECT * FROM `befiz` WHERE `datum` LIKE '2010-12-05%';
