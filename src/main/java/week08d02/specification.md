### Junior/Mid level csoport gyakorlati feladata:

Készíts a `week08d02` csomagban egy `Lottery` osztályt, melynek legyen egy `getNumbers(int interval, int numbers)` metódusa, ami visszaad egy listát amiben `numbers` mennyiségű véletlen szám van `1`-`interval` között, tehát kvázi készíts egy lottósorsoló programot. A sorrendre nem kell figyelni, a lényeg, hogy a számok __különbözők__ legyenek!

### A Senior level csoport gyakorlati feladata:

Adott a countries.txt állomány, melyet helyezz el a projekt gyökérkönyvtárába. A fájlban az adatok a következők: __ország_neve népesség hány_színű_a_zászló szomszédos_országok_száma__. Készíts a week08d02 csomagba egy CountryStatistics osztályt melyben van egy metódus, ami az adatokat beolvassa egy listába. A lista legyen az osztály privát attribútuma, és legyen hozzá getter metódus, figyelj arra, hogy ezen keresztül ne lehessen megváltoztatni a listát. Készíts egy metódust maxPopulaton() néven, ami a listából visszaadja a legnagyobb népességű ország minden adatát.

_countries.txt_
```
Nepal 31 3 2
Csad 13 3 6
Kongoi_Demokratikus_Koztarsasag 79 3 9
Honduras 8 2 3
Kirgizisztán 6 2 4
Dzsibuti 1 4 3
Togo 7 4 3
Kambodzsa 15 3 3
Guyana 1 5 3
Albánia 3 2 4
Libanon 4 3 2
```
