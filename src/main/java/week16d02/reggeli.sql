CREATE DATABASE `tagdij`;
/* befiz
	azon, SZAM, az egyedi azonositoja a befizeto szemelynek
	osszeg, SZAM
	datum, DATUM, (eeee.hh.nn oo:pp:mm)
*/
CREATE TABLE IF NOT EXISTS `befiz` (
	`azon` INT(10) UNSIGNED NOT NULL,
	`datum` DATETIME NOT NULL,
	`osszeg` INT(10) UNSIGNED NOT NULL,
	`befiz_azon` INT(10) UNSIGNED NOT NULL
);
DROP TABLE `befiz`;
ALTER TABLE `befiz` ADD `befiz_azon` INT(10) UNSIGNED NOT NULL;
INSERT INTO `befiz` VALUES (1001, '2020.12.12 12:12:12', 455000, 9001);
INSERT INTO `befiz` VALUES (1002, '2020.12.14 12:12:12', 45000, 9001);
INSERT INTO `befiz` VALUES (1003, '2020.12.15 12:12:12', 5500, 9002);
INSERT INTO `befiz` VALUES (1004, '2020.12.16 12:12:12', 45000, 9003);
INSERT INTO `befiz` VALUES (1005, '2020.12.17 12:12:12', 5500, 9005);
INSERT INTO `befiz` VALUES (1006, '2020.12.18 12:12:12', 55000, 9999);
DELETE FROM `befiz` WHERE 1;
DELETE FROM `befiz` WHERE `azon`=1001;
UPDATE `befiz` SET `befiz_azon`=9001 WHERE `azon`=1002;
/* ugyfel
	azon, SZAM, ami egyedileg azonositja az ugyfelet
	nev, STRING
*/
CREATE TABLE `ugyfel` (
	`azon` INT(10) UNSIGNED NOT NULL,
	`nev` VARCHAR(30) NOT NULL
);
INSERT INTO `ugyfel` VALUES (9001, 'Tamas');
INSERT INTO `ugyfel` VALUES (9002, 'Gabor');
INSERT INTO `ugyfel` VALUES (9006, 'Gabor');
INSERT INTO `ugyfel` VALUES (9003, 'Peter');
INSERT INTO `ugyfel` VALUES (9004, 'Agi');
/*
DELETE FROM `befiz` WHERE 1;
*/
/*
DELETE FROM `befiz` WHERE `azon`=1001;
*/
