DROP DATABASE IF EXISTS `ep_val_hu_2019`;
CREATE DATABASE `ep_val_hu_2019` DEFAULT CHARACTER SET latin2 COLLATE latin2_general_ci;
USE `ep_val_hu_2019`;

DELIMITER $$
CREATE PROCEDURE `teleperedm`(IN `T_Name` VARCHAR(23) CHARSET latin2)
SELECT * FROM `settlements` `t` WHERE `t`.`T_Name` LIKE CONCAT('%', `T_Name`, '%')$$

CREATE PROCEDURE `telepname`(IN `M` CHAR(2), IN `T` CHAR(3))
SELECT `M_Name`, `T_Name` from `settlements` where `M_ID` = `M` and `T_ID` = `T`$$

CREATE FUNCTION `megye`(`M` CHAR(2)) RETURNS varchar(22) CHARSET latin2
return (SELECT `M_Name` FROM `counties` WHERE `M_ID` = `M`)$$

CREATE FUNCTION `telepules`(`M` CHAR(2), `T` CHAR(3)) RETURNS varchar(23) CHARSET latin2
return (SELECT `T_Name` FROM `settlements` WHERE `M_ID` = `M` AND `T_ID` = `T`)$$

CREATE FUNCTION `telepulest`(`M` CHAR(2), `T` CHAR(3)) RETURNS varchar(23) CHARSET latin2
return (SELECT `tt`.`Type` FROM `settlements` `t` join `settlementtype` `tt` on((`t`.`TypeID` = `tt`.`TypeID`)) WHERE `t`.`M_ID` = `M` AND `t`.`T_ID` = `T`)$$
DELIMITER ;

CREATE TABLE `parameters` (
  `fields` varchar(2) NOT NULL,
  `explanation` varchar(70) NOT NULL,
  UNIQUE KEY `fields` (`fields`),
  UNIQUE KEY `explanation` (`explanation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

CREATE TABLE `settlementtype` (
  `TypeID` int(1) NOT NULL,
  `Type` varchar(17) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`TypeID`),
  UNIQUE KEY `Type` (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

CREATE TABLE `counties` (
  `M_ID` char(2) NOT NULL,
  `M_Name` varchar(22) NOT NULL,
  PRIMARY KEY (`M_ID`),
  UNIQUE KEY `M_Name` (`M_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

CREATE TABLE `settlements` (
  `M_ID` char(2) NOT NULL,
  `T_ID` char(3) NOT NULL,
  `T_Name` varchar(23) NOT NULL,
  `TypeID` int(1) NOT NULL,
  PRIMARY KEY (`M_ID`,`T_ID`),
  CONSTRAINT `FK_settlements_to_counties` FOREIGN KEY (`M_ID`)REFERENCES `counties` (`M_ID`),
  CONSTRAINT `FK_settlements_to_settlementtype` FOREIGN KEY (`TypeID`) REFERENCES `settlementtype` (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

CREATE TABLE `results` (
  `M_ID` char(2) NOT NULL,
  `T_ID` char(3) NOT NULL,
  `SZK_ID` char(3) NOT NULL,
  `A` int(8) NOT NULL,
  `E` int(8) NOT NULL,
  `O` int(8) NOT NULL,
  `K` int(8) NOT NULL,
  `L` int(8) NOT NULL,
  `M` int(8) NOT NULL,
  `N` int(8) NOT NULL,
  `01` int(8) NOT NULL,
  `02` int(8) NOT NULL,
  `03` int(8) NOT NULL,
  `04` int(8) NOT NULL,
  `05` int(8) NOT NULL,
  `06` int(8) NOT NULL,
  `07` int(8) NOT NULL,
  `08` int(8) NOT NULL,
  `09` int(8) NOT NULL,
  PRIMARY KEY (`M_ID`,`T_ID`,`SZK_ID`),
  CONSTRAINT `FK_results_to_counties` FOREIGN KEY (`M_ID`)REFERENCES `counties` (`M_ID`),
  CONSTRAINT `FK_results_to_settlements` FOREIGN KEY (`M_ID`,`T_ID`) REFERENCES `settlements` (`M_ID`,`T_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

CREATE VIEW `telepulesosszeg` AS SELECT `megye`(`e`.`M_ID`) AS `Megye/Főváros`,`telepules`(`e`.`M_ID`,`e`.`T_ID`) AS `Település/Kerület`,`telepulest`(`e`.`M_ID`,`e`.`T_ID`) AS `Type`,COUNT(`e`.`SZK_ID`) AS `Szavazókör db`,SUM(`e`.`A`) AS `A`,SUM(`e`.`E`) AS `E`,SUM(`e`.`O`) AS `O`,SUM(`e`.`K`) AS `K`,SUM(ABS(`e`.`L`)) AS `ABS(L)`,SUM(`e`.`M`) AS `M`,SUM(`e`.`N`) AS `N`,SUM(`e`.`01`) AS `1. MSZP-PÁRBESZÉD`,SUM(`e`.`02`) AS `2. MKKP`,SUM(`e`.`03`) AS `3. JOBBIK`,SUM(`e`.`04`) AS `4. FIDESZ`,SUM(`e`.`05`) AS `5. MOMENTUM`,SUM(`e`.`06`) AS `6. DK`,SUM(`e`.`07`) AS `7. MI HAZÁNK`,SUM(`e`.`08`) AS `8. MUNKÁSPÁRT`,SUM(`e`.`09`) AS `9. LMP` FROM `results` `e` GROUP BY `telepules`(`e`.`M_ID`,`e`.`T_ID`) ORDER BY `e`.`M_ID`,`e`.`T_ID`;

CREATE VIEW `megyeosszeg` AS SELECT `m`.`M_Name` AS `Megye/Főváros`,COUNT(`e`.`SZK_ID`) AS `Szavazókör db`,SUM(`e`.`A`) AS `A`,SUM(`e`.`E`) AS `E`,SUM(`e`.`O`) AS `O`,SUM(`e`.`K`) AS `K`,SUM(ABS(`e`.`L`)) AS `ABS(L)`,SUM(`e`.`M`) AS `M`,SUM(`e`.`N`) AS `N`,SUM(`e`.`01`) AS `1. MSZP-PÁRBESZÉD`,SUM(`e`.`02`) AS `2. MKKP`,SUM(`e`.`03`) AS `3. JOBBIK`,SUM(`e`.`04`) AS `4. FIDESZ`,SUM(`e`.`05`) AS `5. MOMENTUM`,SUM(`e`.`06`) AS `6. DK`,SUM(`e`.`07`) AS `7. MI HAZÁNK`,SUM(`e`.`08`) AS `8. MUNKÁSPÁRT`,SUM(`e`.`09`) AS `9. LMP` FROM (`results` `e` join `counties` `m` on((`e`.`M_ID` = `m`.`M_ID`))) GROUP BY `e`.`M_ID` ORDER BY `e`.`M_ID`;

CREATE VIEW `orszagosszeg` AS SELECT COUNT(`e`.`SZK_ID`) AS `Szavazókör db`,SUM(`e`.`A`) AS `A`,SUM(`e`.`E`) AS `E`,SUM(`e`.`O`) AS `O`,SUM(`e`.`K`) AS `K`,SUM(ABS(`e`.`L`)) AS `ABS(L)`,SUM(`e`.`M`) AS `M`,SUM(`e`.`N`) AS `N`,SUM(`e`.`01`) AS `1. MSZP-PÁRBESZÉD`,SUM(`e`.`02`) AS `2. MKKP`,SUM(`e`.`03`) AS `3. JOBBIK`,SUM(`e`.`04`) AS `4. FIDESZ`,SUM(`e`.`05`) AS `5. MOMENTUM`,SUM(`e`.`06`) AS `6. DK`,SUM(`e`.`07`) AS `7. MI HAZÁNK`,SUM(`e`.`08`) AS `8. MUNKÁSPÁRT`,SUM(`e`.`09`) AS `9. LMP` FROM `results` `e`;
