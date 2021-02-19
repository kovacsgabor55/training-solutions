-- 1.  Mi MADAGASZKÁR fővárosa?
SELECT fovaros FROM orszagok WHERE orszag='MADAGASZKÁR';
-- 2.  Melyik ország fővárosa OUAGADOUGOU?
SELECT orszag FROM orszagok WHERE fovaros='OUAGADOUGOU';
-- 3.  Melyik ország autójele a TT?
SELECT orszag FROM orszagok WHERE Autojel='TT';
-- 4.  Melyik ország pénzének jele az SGD?
SELECT orszag FROM orszagok WHERE penzjel='SGD';
-- 5.  Melyik ország nemzetközi telefon-hívószáma a 61?
SELECT orszag FROM orszagok WHERE telefon=61;
-- 6.  Mekkora területű Monaco?
SELECT terulet FROM orszagok WHERE orszag='Monaco';
-- 7.  Hányan laknak Máltán?
SELECT nepesseg*1000 AS nepesseg FROM orszagok WHERE orszag='Málta';
-- 8.  Mennyi Japán népsűrűsége?
SELECT nepesseg*1000/terulet AS nepsuruseg FROM orszagok WHERE orszag='Japán';
-- 9.  Mely országok népsűrűsége nagyobb 500 fő/km2-nél?
SELECT orszag FROM orszagok WHERE (nepesseg/terulet)>0.5;
-- 10.  Melyek a szigetországok?
SELECT orszag FROM orszagok WHERE foldr_hely LIKE '%sziget%';
-- 11.  Melyik a első hat legnagyobb területű ország?
SELECT orszag FROM orszagok ORDER BY terulet DESC LIMIT 6;
-- 12.  Melyik három ország területe a legkisebb?
SELECT orszag FROM orszagok ORDER BY terulet ASC LIMIT 3;

-- Összegző lekérdezések - SUM, AVG, COUNT, MIN, MAX:

-- 1.  Hány lakosa van a Földnek?
SELECT SUM(nepesseg)*1000 AS `fold_lakossag` FROM orszagok;
-- 2.  Mennyi a Föld népsűrűsége?
SELECT SUM(nepesseg)*1000/SUM(terulet) AS `fold_nepsurusege` FROM orszagok;
-- 3.  Hány 1.000.000 km2-nél nagyobb területű ország van?
SELECT COUNT(orszag) AS `egymillional_nagyobb` FROM orszagok WHERE terulet > 1000000;
-- 4.  Hány ország területe esik 50.000 és 150.000 km2 közé?
SELECT COUNT(orszag) AS `kettokoze` FROM orszagok WHERE terulet BETWEEN 50000 AND 150000;
-- 5.  Hány 1.000.000-nál kevesebb lakosú ország van?
SELECT COUNT(orszag) AS `egymillional_kevesebb` FROM orszagok WHERE 1000000 > nepesseg;
-- 6.  Hány olyan ország van, aminek a területe kisebb, mint 10.000 km2, vagy a lakossága kevesebb 1.000.000-nál?
SELECT COUNT(orszag) AS `egymillional_kevesebb` FROM orszagok WHERE 10000 > terulet OR nepesseg*1000 < 1000000;
-- 7.  Hány ország pénzneme a kelet-karib dollár?
SELECT COUNT(orszag) AS `penzeme_karbibi_dollar` FROM orszagok WHERE penznem LIKE 'kelet-karib dollár';
-- 8.  Hány ország nevében van benne, hogy "ORSZÁG"?
SELECT COUNT(orszag) AS `tartlamazza_ORSZAG` FROM orszagok WHERE orszag LIKE '%ORSZÁG%';
-- 9.  Hány ország van Afrikában?
SELECT COUNT(orszag) AS `afrikaban_van` FROM orszagok WHERE foldr_hely LIKE '%Afrika%';
-- 10.  Mennyi Afrika lakossága?
SELECT SUM(nepesseg)*1000 AS `afrika_nepessege` FROM orszagok WHERE foldr_hely LIKE '%Afrika%';
-- 11.  Mennyi Európa területe?
SELECT SUM(terulet) AS `europa_terulete` FROM orszagok WHERE foldr_hely LIKE '%Európa%';
-- 12.  Mennyi Európa népsűrűsége?
SELECT SUM(nepesseg)*1000/SUM(terulet) AS `europa_nepsurusege` FROM orszagok WHERE foldr_hely LIKE '%Európa%';
-- 13.  Hány országnak nincs autójelzése?
SELECT COUNT(orszag) AS `nincs_autojel` FROM orszagok WHERE autojel = '';
-- 14.  Hány országban nem 100 a váltószáma az aprópénznek?
SELECT COUNT(orszag) AS `nem_szaz_valto` FROM orszagok WHERE valtopenz NOT LIKE '100 %';
-- 15.  Hány országnak nagyobb a népessége, mint Romániának?
SELECT COUNT(orszag) AS `nagyobb_mint_roman` FROM orszagok WHERE nepesseg > (SELECT nepesseg FROM orszagok WHERE orszag = 'ROMÁNIA');
-- 16.  Mennyi Európa népessége és mennyi ország van Európában?
SELECT SUM(nepesseg)*1000 AS europa_nepessege, COUNT(orszag) AS europa_orszagok FROM orszagok  WHERE foldr_hely LIKE '%Európa%';
-- 17.  Mennyi olyan ország van, aminek a területe kisebb, mint Törökország
SELECT COUNT(orszag) AS `kisebb_mint_torok` FROM orszagok WHERE terulet < (SELECT terulet FROM orszagok WHERE orszag = 'TÖRÖKORSZÁG');

-- Beágyazott lekérdezések:

-- 1.  Hány ország területe kisebb Magyarországénál?
SELECT COUNT(`orszag`) FROM `orszagok` WHERE `terulet` < (SELECT `terulet`FROM `orszagok` WHERE `orszag` = 'MAGYARORSZÁG');
-- 2.  Melyik a legnagyobb területű ország, és mennyi a területe?
SELECT orszag,terulet FROM orszagok ORDER BY terulet DESC LIMIT 1;
-- 3.  Melyik a legkisebb  területű ország, és mennyi a területe?
SELECT orszag,terulet FROM orszagok ORDER BY terulet ASC LIMIT 1;
-- 4.  Melyik a legnépesebb ország, és hány lakosa van?
SELECT orszag,nepesseg*1000 AS lakossag FROM orszagok ORDER BY nepesseg DESC LIMIT 1;
-- 5.  Melyik a legkisebb népességű ország, és hány lakosa van?
SELECT orszag,nepesseg*1000 AS lakossag FROM orszagok ORDER BY nepesseg ASC LIMIT 1;
-- 6.  Melyik a legsűrűbben lakott ország, és mennyi a népsűrűsége?
SELECT orszag, nepesseg*1000/terulet AS nepsuruseg FROM orszagok ORDER BY nepesseg/terulet DESC LIMIT 1;
-- 7.  Melyik a legritkábban lakott ország, és mennyi a népsűrűsége?
SELECT orszag, nepesseg*1000/terulet AS nepsuruseg FROM orszagok ORDER BY nepesseg/terulet ASC LIMIT 1;
-- 8.  Melyik a legritkábban lakott európai ország, és mennyi a népsűrűsége?
SELECT orszag, nepesseg*1000/terulet AS nepsuruseg FROM orszagok WHERE foldr_hely LIKE '%Európa%' ORDER BY nepesseg/terulet ASC LIMIT 1;
-- 9.  Melyik a legnagyobb afrikai ország és mekkora?
SELECT orszag,terulet FROM orszagok WHERE foldr_hely LIKE '%Afrika%' ORDER BY terulet DESC LIMIT 1;
