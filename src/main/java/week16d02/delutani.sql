CREATE DATABASE `tagdij`;
/* befiz
	azon, SZAM, az egyedi azonositoja a befizeto szemelynek
	osszeg, SZAM
	datum, DATUM, (eeee.hh.nn oo:pp:mm)
*/
CREATE TABLE `befiz` (
	`azon` INT(10) UNSIGNED NOT NULL,
	`datum` DATETIME NOT NULL,
	`osszeg` INT(10) UNSIGNED NOT NULL,
	`ugyfel_azon` INT(10) UNSIGNED NOT NULL
);
CREATE TABLE `ugyfel` (
	`azon` INT(10) UNSIGNED NOT NULL,
	`nev` VARCHAR(30) NOT NULL
);
INSERT INTO `ugyfel` VALUES (9001, 'Tamas');
INSERT INTO `ugyfel` VALUES (9002, 'Gabor');
INSERT INTO `ugyfel` VALUES (9003, 'Peter');
INSERT INTO `ugyfel` VALUES (9004, 'Agi');
INSERT INTO `befiz` VALUES (1001, '2020.12.12 12:12:12', 455000, 9001);
INSERT INTO `befiz` VALUES (1002, '2020.12.14 12:12:12', 45000, 9002);
INSERT INTO `befiz` VALUES (1003, '2020.12.15 12:12:12', 5500, 9003);
INSERT INTO `befiz` VALUES (1004, '2020.12.16 12:12:12', 45000, 9001);
INSERT INTO `befiz` VALUES (1005, '2020.12.17 12:12:12', 5500, 9002);
INSERT INTO `befiz` VALUES (1006, '2020.12.18 12:12:12', 55000, 9001);
INSERT INTO `befiz` VALUES (1006, '2020.12.18 19:12:12', 200000, 9002);
INSERT INTO `befiz` VALUES (1006, '2019.12.18 19:12:12', 2000, 9004);
INSERT INTO `befiz` VALUES (1006, '2012.12.18 19:12:12', 2000, 9003);
INSERT INTO `befiz` VALUES (1006, '2020.12.12 19:12:12', 2000, 9003);
SELECT * FROM `befiz`;
SELECT * FROM `befiz` WHERE `osszeg` < 10000 AND `azon` = 1003 OR `azon` = 1005;
SELECT `datum`, `osszeg` FROM `befiz`;
SELECT `datum`, `osszeg` FROM `befiz` WHERE `osszeg` < 10000;
SELECT COUNT(`azon`) FROM `befiz`;
SELECT COUNT(`azon`) FROM `befiz` WHERE `osszeg` < 10000;
SELECT SUM(`osszeg`) FROM `befiz`;
SELECT MAX(`osszeg`), MIN(`osszeg`), SUM(`osszeg`), COUNT(`azon`) FROM `befiz`;
SELECT MAX(`osszeg`) AS 'MAX(összeg)', MIN(`osszeg`), SUM(`osszeg`), COUNT(`azon`) FROM `befiz`;
SELECT AVG(`osszeg`) FROM `befiz`;
SELECT * FROM `befiz` ORDER BY `osszeg` DESC;
SELECT * FROM `befiz` GROUP BY `osszeg` ORDER BY `osszeg` DESC;
SELECT * FROM `befiz` WHERE `datum` LIKE '2020-12-18%';
SELECT * FROM `befiz` WHERE `datum` LIKE '%12-18%';
SELECT * FROM `befiz` WHERE `datum` LIKE '%12-12%' AND `datum` NOT LIKE '2012-%';
/* ugyfel
	azon, SZAM, ami egyedileg azonositja az ugyfelet
	nev, STRING
*/
/*
DELETE FROM `befiz` WHERE 1;
*/
/*
DELETE FROM `befiz` WHERE `azon`=1001;
*/
