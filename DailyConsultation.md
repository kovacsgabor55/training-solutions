# Konzultációs feladatok

> A feladatoknál írj teszteseteket.

## 2020-11-03 (`week02d02`) :heavy_check_mark: :grey_question:

Írj egy `Phone` osztályt, `type` (`String`) és mem (`int`) attribútumokkal!
Generálj konstruktort, gettert és settert! Írj bele egy `main` metódust, amivel példányosítasz egy osztályt, és kiírod az attribútumok értékeit!

## 2020-11-04 (`week02d03`) :heavy_check_mark: :grey_question:

Írj egy `Product` oszályt `String name` és `String code` attribútumokkal!
Legyen egy konstruktora a két attribútummal! Legyen egy `areTheyEqual()`
metódusa, mely kap egy másik `Product` példányt, és eldönti, hogy
azonos-e az adott példánnyal. Két termék akkor egyezik, ha
a nevük megegyezik.

__Bónusz:__ szigorúbb egyelőség a feltételre: a két termék kódjának hosszának különbsége
maximum egy karakter lehet.

## 2020-11-05 (`week02d04`) :heavy_check_mark: :grey_question:

Hozz létre egy `InputNames` Java osztályt, melynek van egy `main` metódusa.
Ciklusban kérj be öt nevet! A neveket tárold el egy tömbben!
Írd ki a tömb tartalmát, sortöréssel elválasztva (írd bele, hogy hanyadik elem - 1-től sorszámozva)!

## 2020-11-06 (`week02d05`) :heavy_check_mark: :grey_question:

Hozz létre egy `Languages` osztályt, `main` metódussal!
Ebben hozz létre egy listát, mely karakterláncokat tartalmaz!
Vegyetek fel 3 elemet: `Java`, `Python`, `JavaScript`!

Írd ki, az öt karakternél hosszabb programozási nyelveket!

## 2020-11-10 (`week03d02`) :heavy_check_mark: :grey_question:

Írj egy `Position` osztályt, melynek van egy `name` és egy `bonus` attribútuma!
Egy alkalmazotti pozíciót jelöl, melynek a `bonus` attribútuma tárolja, hogy
ebben a pozícióban évente mennyi bónuszt kap egy alkalmazott.
A `main` metódusban hozz létre egy `Position` objektumokat tartalmazo listát!

Menj végig a lista elemein, és írd ki azokat, ahol a bónusz magasabb, mint
`150_000`. Azonban a kiírás  
formátumát a `Position` osztály `toString()` metódusában implementáld!

## 2020-11-12 (`week03d04`) :heavy_check_mark: :grey_question:

Írj egy `Phone` oszályt, melynek van egy `prefix` és egy `number`
`String` attribútuma! Írj egy `PhoneParser` osztályt egy
`parse(String)` metódussal, ami beolvas egy `10-1234567`
formátumú szöveget, és visszaad egy `Phone` objektumot,
feltöltve a `prefix` értékét `10`, a `number` értékét `1234567`
értékekkel!

## 2020-11-13 (`week03d05`) :heavy_check_mark: :grey_question:

Írj egy `Operation` osztályt, mely konstruktorban kap egy
összeadást, pl. `68+12`! A `getResult()` metódus visszaadja a
művelet eredményét. Egy belső `leftOperand` és `rightOperand`
attribútumba dolgozz!

## 2020-11-16 (`week04d01`) :heavy_check_mark: :grey_question:

Készítsd el a `NameChanger` osztályt, melynek privát attribútuma
legyen a `String fillName`, mely egy ember teljes nevét reprezentálja!
A `fullName` attribútum `[vezetéknév][szóköz][keresztnév]` formátumban épül fel.
A konstruktor állítsa be a paraméterül kapott értékre az adattagot,
de ha az érték `null`, vagy üres String, akkor dobjon egy
`IllegalAgrumentException` kivételt a következő üzenettel:
`Invalid name:[paraméter értéke]`!

Legyen egy `changeFirstName(String firstName)` metódusa, mely megváltoztatja az
objektum állapotát és kicseréli a vezetéknevet a paraméterül kapott értékre!

## 2020-11-17 (`week04d02`) :heavy_check_mark: :grey_question:

A `Search` osztályban írj egy `getIndexesOfChar()`
metódust, mely első paraméterként vár egy `String` értéket,
második paraméterként egy `char` értéket! Visszaad egy listát,
melyben visszaadja, hogy a karakter hanyadik indexeken
szerepel az első paraméterként átadott listában.

Pl.: `almafa` szóban a `a` karakter: `0, 3, 5`.

## 2020-11-18 (`week04d03`) :x:

Írj egy számkitaláló programot a `GuessTheNumber` osztályba! A
program kitalál egy véletlenszerű számot `1` és `100` között. Majd
bekér a felhasználótól ciklusban számokat. Mindig megmondja,
hogy a szám, kisebb, nagyobb vagy egyenlő-e mint a gondolt szám.

__Bónusz:__ max `6`-szor lehet kérdezni!

## 2020-11-24 (`week05d02`)

### Junior/Medior/Senior :heavy_check_mark: :x:

A `week05d02.ChangeLetter` osztályban írj meg egy `String changeVowels(String)` metódust, amely kicseréli a paraméterként átadott szövegben az angol magánhangzókat csillag karakterre.

## 2020-11-25 (`week05d03`)

### Junior/Medior :heavy_check_mark:

Írj egy olyan metódust az `week05d03.ListCounter` osztályban, mely egy kapott `List`ából (`String`) összeszámolja azokat amik `'a'` vagy `'A'` betűvel kezdődnek,
Ha nulla elemű a tömb, vagy nincs benne ilyen elem, akkor `0`-t adjon vissza.

### Senior :x:

Készíts egy osztályt `UserValidator` néven, mely rendelkezik egy `validate` nevű metódussal. A metódus `User` objektumok listáját várja és a feladata az, hogy ellenőrizze, hogy az `User` `name` attribútuma nem üres és az `User` `age` attribútuma nem negatív és nem nagyobb, mint `120`! Ha találunk egy nem megfelelő objektumot, akkor dobjunk el egy `InvalidArgumentException` kivételt, mely tartalmaz egy hibaüzenetet a validációs hiba okával!

## 2020-11-26 (`week05d04`)

### Junior/Medior :heavy_check_mark:

Készíts egy `week05d04.Product` osztályt amelyben egy termékről tárolod a nevét és a lejárati dátumát (`LocalDate`). Legyen egy konstruktora, ami a nevet kapja meg illetve a lejárati dátumot három részletben `int year, int month, int day`. (`public Product(String name, int year, int month, int day)`)
A lejárati dátumot a konstruktorban állítsd össze.
Legyen mindkettőhöz `get`ter metódus.
Készíts egy `week05d04.Store` osztályt, melyben van egy `Product`okat tároló lista. Legyen benne egy `addProduct(Product)` metódus.

__Bónusz:__ Legyen benne egy `getNumberOfExpired()` metódus ami visszaadja a lejárt termékek számát. Használd a `LocalDate.now()` és az `isBefore()` metódusokat.

### Senior :grey_question:

Készíts egy osztályt `Product` néven, melynek van egy `price` (`long`) és egy `currency` (`String`) mezője. A `Product` a konstruktorában ellenőrizze a `currency` mezőt, melynek az értéke vagy `HUF`, vagy `USD` lehet.
Készíts egy metódust `convertPrice` néven, melynek egy paramétere van (`currency`) és visszaadja a `currency`-nek megfelelő összeget (`double`). Használjunk `300` forintos átváltási árfolyamot! Példa: ha a `Product`-ot létrehozzuk a következőképp: `new Product(150, "HUF")`, majd meghívjuk a `convertPrice`-ot "`USD`" paraméterrel, akkor az elvárt visszatérési érték `0.5`.

__Bónusz feladat:__ Használjunk `enum`-ot `String` helyett a pénznem reprezentációjára

## 2020-11-27 (`week05d05`)

### Junior/Medior :heavy_check_mark:

Készíts egy osztályt `week05d05.User` néven, melynek van egy `firstName (String)`, egy `lastName (String)` és egy `email (String)` mezője. Legyen ellenőrzés az `User` konstruktorában, mely hibát jelez, ha nincs `@` és `.` (pont) az e-mail címben! Készíts egy metódust is `getFullName` névvel, mely visszaadja a `firstName` és a `lastName` változókat összefűzve. Legyen köztük egy whitespace ("` `").

### Senior :x:

Készítsünk egy `Song` osztályt, melynek az alábbi mezői vannak:
- `String name`
- `long lengthInSeconds`
- `String artist`

A `Song` konstruktorában ellenőrizzük, hogy a `name` és az `artist` üres-e. Dobjon kivételt, ha igen.
Ellenőrizzük továbbá a `lengthInSeconds`-ot is, hogy nagyobb legyen, mint `0`!
Készítsünk egy `Playlist` osztályt, melynek van egy konstruktora, amiben `Song`-ok `List`áját fogadja el.
Írjunk egy metódust `findByLengthGreaterThan` néven, amely egy `int`-et vár paraméterként `mins` néven.
Azoknak a `Song`-oknak a listáját adjuk vissza, amelyek hosszabbak percben (!), mint a `Song` `lengthInSeconds` mezője.

__Bónusz feladat:__ Implementáljuk megfelelően a `toString` metódust a `Song` és a `Playlist` osztályban, hogy a `Playlist`et-et kiírva a konzolra olvasható eredményt kapjunk!

## 2020-11-30 (`week06d01`)

### Junior/Medior :heavy_check_mark:

Írj egy olyan metódust az `week06d01.ListSelector` osztályban, mely egy kapott listából minden második elemet kiválogat, és egy szövegként összerak, szögletes zárójelek között.
A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.
Ha üres a lista, akkor üres `String`et adjunk vissza. Ha a paraméterül kapott lista `null`, akkor dobjunk `IllegalArgumentException`t a metódusban.

### Senior :x:

Írj egy `week06d01.SeparatedSum.sum(String s)` metódust, amely kap egy `String`-et, melyben lebegőpontos számok szerepelnek pontosvesszővel elválasztva. A számoknál vessző a tizedes elválasztó. Ezt szétszedi, és összeadja külön a pozitív és külön a negatív számokat. Mivel térnél vissza ebből a metódusból?

## 2020-12-01 (`week06d02`)

### Junior/Medior :heavy_check_mark:

Hozz létre egy `week06d02.Product` osztályt amelynek adattagjai a név, kategória és ár, rendre, `String`, `String` `int`. Készíts egy `Store` osztályt benne egy `Product` listával, amit konstruktorban kap meg. Legyen egy `getProductByCategoryName(Category)`, ami visszaadja, hogy a paraméterül kapott kategóriából hány darab van a listában.

__Bónusz:__ A kategória legyen `enum` `FROZEN, DAIRY, BAKEDGOODS, OTHER` felsorolókkal.

### Senior :x:

Hozz létre egy `week06d02.Product` osztályt amelynek adattagjai a név, kategória és ár. A kategória legyen `enum` `FROZEN, DAIRY, BAKEDGOODS, OTHER` felsorolókkal. Készíts egy `Store` osztályt benne egy `Product` listával, amit konstruktorban kap meg. Legyen egy `getProductsByCategory()` aminek a lényege, hogy visszaadja valamilyen adatszerkezetben, hogy melyik kategóriából hány darab van a listában. A "valamilyen adatszerkezet" a kreativitásodra van bízva, az a lényeg, hogy valahogy egyben kapjam meg, hogy melyik kategóriából hány darab van. A `getProductsByCategory()` az összeset adja vissza.

## 2020-12-02 (`week06d03`)

### Junior/Medior :heavy_check_mark:

A `week06d03.WordEraser` osztályban legyen egy `eraseWord(String words, String word)` metódus, amely az első paraméter szöveget úgy változtatja meg, hogy a második paraméter összes előfordulását törli belőle. A `words` paraméterben a szavak szóközzel vannak elválasztva. A metódus térjen vissza a törölni kívánt szavak nélküli `String`gel. (Mellőzzük a `replace` és `replaceAll` használatát)

### Senior :x:

`week06d03.Series` osztályban hozz létre egy `calculateSeriesType` metódust, amely egész számok listáját kapja, és eldönti, hogy növekvő, csökkenő vagy össze-vissza sorozatról van-e szó! Feltétel, hogy a bemeneti lista nem tartalmaz egymás után egyenlő értékeket. Ha a lista üres, vagy csak egy elemből áll, dobj kivételt! Mivel térnél vissza?

## 2020-12-03 (`week06d04`)

### Junior/Medior :heavy_check_mark:

Készíts az `week06d04` csomagban egy `Budget` osztályt, amely a konstruktorában `Item` példányokat vár listában (`List`). Az `Item` tartalmazza az alábbi attribútumokat: `int price`, `int month`, `String name`. A `Budget` osztály tárolja el egy attribútumban a konstruktorban megkapott `items` listát. Írjunk egy metódust, `getItemsByMonth` néven, amely egy hónapot vár (`1`-`12`) és visszaadja az `Item`eket az adott hónapban!

__Bónusz feladat:__ ellenőrizzük a bemeneti paramétereket!

### Senior :x:

`week06d4.ShoppingCart` osztályba dolgozz! Legyen egy `addItem(String name, int quantity)` metódusa, mellyel új bevásárlólista tételt lehet felvenni (termék neve és mennyisége). Az adatokat egy `Item` listába tárolja. Amennyiben már benne van az adott termék, ne újonnan vegye fel, hanem adja hozzá a mennyiséget a már felvett tételhez. Lehessen visszakérdezni név alapján a felvett mennyiséget a `getItem(String name)`: `int` metódussal. Ha nem szerepel benne, `0` értéket adjon vissza.

## 2020-12-04 (`week06d05`)

### Junior/Medior :heavy_check_mark:

Készíts a `week06d05` csomagban egy `Biscuit` nevű osztályt, amelynek van 2 attribútuma: `BiscuitType type` és `int gramAmount`. A `BiscuitType` legyen felsorolásos típus a 3 kedvenc keksz fajtáddal. A `Biscuit` nevű osztálynak legyen egy `static` metódusa `of` néven, mely paraméterként egy `BiscuitType`-ot, és egy `int gramAmount`-ot vár és visszaad egy új `Biscuit` objektumot amelyet a megadott paraméterek alapján hoz létre.

__Bónusz feladat:__ konzolra írás esetén a Biscuit jelenítse meg a type és a gramAmount mezőket!

### Senior :x:

Készíts a `week06d05` csomagban egy `Bottle` nevű osztályt, amelynek van 2 attribútuma: `BottleType type` és `int filledUntil`. A `BottleType` legyen felsorolásos típus az alábbi értékekkel: `GLASS_BOTTLE` és `PET_BOTTLE`, . A `Bottle` nevű osztálynak legyen egy `static` metódusa `of` néven, mely paraméterként egy `BottleType`-ot vár és visszaad egy új `Bottle` objektumot amelyet a megadott paraméter alapján hoz létre. A `Bottle` osztálynak legyen egy `fill` metódusa, mely egy `int fillAmount` paramétert vár. A `fill` meghívása esetén végezzen ellenőrzést, hogy megtelt-e már a `Bottle` objektum. Az ehhez szükséges `int maximumAmount` mezőt a `BottleType` tartalmazza! Ha túlcsordul a `Bottle` objektum, akkor dobjunk kivételt!

## 2020-12-07 (`week07d01`)

### Junior/Medior :heavy_check_mark:

Készíts egy osztályt a `week07d01` csomagba `MathAlgorithms` néven. Ebben az osztályban legyen egy `isPrime(int x)` metódus ami a paraméterül kapott számról eldönti, hogy prím-e vagy sem és ennek megfelelően `true` vagy `false` értékkel tér vissza. Aki már tart ott és tudja mit jelent a `static` az nyugodtan implementálhatja a metódust statikus metódus ként. Az egyszerűség kedvért a prímeket most csak a pozitív egész számok körében értelmezzük, így __bónuszként__ rá lehet ellenőrizni, hogy `x>0`  és ha nem akkor kivételt dobni. Prímeknek tekintjük azokat számokat amelyek csak eggyel és önmagukkal oszthatók, tehát a `2`,`3`,`5`,`7`,`11`,`13` stb.

### Senior :heavy_check_mark: :x: :heavy_check_mark:

Készíts egy osztályt a `week07d01` csomagba `Fibonacci` néven. Legyen benne egy `fib` metódus, ami egy `int n` paramétert vár. A visszatérési értékünk legyen egy `long` szám, ami az `n`-edik fibonacci számot tartalmazza. (A fibonacci szám az az az előző kettő fibonacci szám összege és az első két szám az `1`, `1`.

__Bónusz feladat:__ implementáljuk az algoritmust ciklus nélkül és mentsük el a részeredményeket egy statikus változóba.

__Pontosítás:__ Ha `n = 0`, akkor `0`-t adunk vissza, ha `n=1`, akkor `1`-et, ezért lesz a `2`. elem szintén `1`, mert `0 + 1 = 1`

## 2020-12-08 (`week07d02`)

### Junior/Medior :heavy_check_mark:

Készíts egy `week07d02.DigitSum` osztályt és benne `sumOfDigits(int x)` metódus amely visszaadja a paraméterül kapott szám számjegyeinek összegét! pl.: `123` esetén a visszatérési érték `6`.

### Senior :heavy_check_mark: :x: :x:

Készítsünk a `week07d02` csomagba egy interfészt `User` néven. Az interfésznek legyen egy `String getUsername()`, egy `String getFirstName()`, egy `String getLastName()` és egy `String getFullName()` metódusa. Implementáljuk az `User` interfészt egy `UserImpl` nevű osztályba, mely konstruktor paraméterként várja az `username`, a `firstName` és a `lastName` paramétereket. A `getFullName` metódushoz adjunk az interfészben egy default implementációt!

__Bónusz feladat:__ Készítsünk egy statikus függvényt az `User` interfészben `of` néven, amely létrehoz egy új `User` típusú objektumot!

## 2020-12-09 (`week07d03`)

### Junior/Medior :heavy_check_mark:

A `week07d03` csomagban hozz létre egy `NumberList` osztályt. Ennek legyen egy metódusa `isIncreasing(List<Integer>)` mely egy számokból álló listát vár paraméterül és megnézi, hogy a listában a számok növekvő sorrendben szerepelnek-e és ennek megfelelően igaz vagy hamis értékkel tér vissza. Speciális eset ha két egymást követő szám egyenlő, ez nem probléma a `1`,`2`,`3`,`3`,`3`,`5` számokat növekvőnek tekintjük.

### Senior :heavy_check_mark:

Készítsünk a `week07d03` csomagba egy `Date` osztályt, mely az alábbi attribútumokkal rendelkezik: `int year`, `int month`, `int day`. Az összes attribútum legyen `final`! Készítsünk továbbá egy statikus `of` metódust, mely a `year`, `month` és `day` paramétereket várja és létrehoz egy `Date` objektumot ezek alapján. Legyen továbbá a `Date`-nek egy `withYear(int year)`, `withMonth(int month)` és egy `withDay(int day)` metódusa, melyek egy új `Date` objektumot adnak vissza az eredeti `Date` objektum adataival, azzal a különbséggel, hogy az új objektum a megadott paraméter értékét tartalmazza a megfelelő helyen (`year`, `month` vagy `day`).

## 2020-12-10 (`week07d04`)

### Junior/Medior :heavy_check_mark:

Hozz létre egy `week07d04.Lab` nevű osztályt, ami azt tárolja el, hogy melyik feladattal készültél el. Három attribútuma: `title` ami a tananyag neve, egy `completed`, hogy elkészültél-e vele, és a `completedAt`, ami azt tárolja, hogy mikor. Legyen két konstruktora! Az egyik csak a címet várja, ekkor úgy állítsa be a példányt, hogy még nem készültél el. Legyen egy másik, ami várja a címet és a dátumot. Ekkor azt állítsa be, hogy elvégezted a gyakorlati feladatot. Írj egy `complete` metódust, ami kap egy dátumot, és beállítja, hogy elvégezted a gyakorlati feladatot. Legyen egy `complete` metódusa, ami semmit nem vár, ez azt állítja be, hogy MOST végezted el a gyakorlati feladatot. Írd meg a `toString` metódusát is!

### Senior :x:

A `week07d04.ShoppingList` osztályba írj egy `long calculateSum(String path)` metódust, amely a paraméterként átadott fájlból beolvassa a bevásárlólista tartalmát, és összegzi az árat. A fájl a következő formátumú sorokat tartalmazza: `kenyér;2;30` ahol az első a termék neve, a második a darabszám, a harmadik az egységár. Azaz ezen sor esetén `2*30 = 60` értékkel kell számolni.

## 2020-12-11 (`week07d05`)

### Junior/Medior :heavy_check_mark: :x:
Készíts a `week07d05` csomagba egy `Vehicle`, egy `Car`, egy `Truck` és egy `Motorcycle` osztályt. A `Vehicle` osztálynak legyen egy `int getNumberOfGears` és egy `TransmissionType getTransmissionType` metódusa. A fenti osztályok értelemszerűen öröklődjenek egymásból és mindegyiknek implementálja a sebességek számát és a váltó típusát. A lehetséges váltótípusok: `MANUAL, AUTOMATIC, SEQUENTIAL`. Az alapértelmezett váltó típus (a `Vehicle` osztályban) `MANUAL`, de a `Car` automatikus, míg a `Motorcycle` `SEQUENTIAL`. Az alapértelmezett sebesség szám `5`.

### Senior :x:
Kérj be a felhasználótól három sort, majd a fájl nevét. Mentsd el a sorokat ebbe a fájlba. A `week07d05.SaveInput` osztályba dolgozz!

## 2020-12-14 (`week08d01`)

### Junior/Medior :heavy_check_mark:

A feladatban egy robot mozgását fogjuk szimulálni. Képzelj el egy koordináta rendszert, ahol a robot az origóban van. A robot négy irányba képes mozogni fel, le, balra és jobbra. A `week08d01.Robot` osztályban írj egy `move()` metódust ami egy karaktersorozatot vár.  pl: `FFLLLLLBBBBJJJJJJJ`, ahol az `F` = fel, `L`=le, `B`=bal, `J`=jobb. A metódus visszatérési értéke legyen a robot mozgás utáni pozíciója. A feladat szabadon bővíthető osztályokkal és metódusokkal. Bónusz kiegészítés, hogyha más karaktert is tartalmaz a paraméter `String` nem csak a `FLBJ` valamelyikét, akkor dobjunk `IllegalArgumentException`t!

### Senior :x:

A török szultán elhatározza, hogy a `100` nap múlva lévő születésnapján szabadon enged néhány rabot a börtönéből. A börtönben `100` cella van. Mindegyik cella zárva van. Ha egyet fordítunk a kulcson akkor nyitva lesz, ha még egyet akkor zárva ha hármat akkor ismét nyitva és így tovább.
A szultán azt a parancsot adja, hogy az első nap mindegyik cellán fordítsanak egyet.  (Ekkor minden cella nyitva lesz) A második napon minden másodikon fordítsanak egyet, így minden második zárva lesz. A harmadik napon minden harmadikon fordítsanak egyet így a 3. cella zárva , de a 6. cella például nyitva lesz. A `week08d01.Sultan` osztályba írj egy metódust `openDoors()` néven,  aminek visszatérési értékéből kiderül, hogy mely ajtók lesznek nyitva a `100`. napon! Az osztály szabadon bővíthető!

## 2020-12-15 (`week08d02`)

### Junior/Medior :heavy_check_mark:

Készíts a `week08d02` csomagban egy `Lottery` osztályt, melynek legyen egy `getNumbers(int interval, int numbers)` metódusa, ami visszaad egy listát amiben `numbers` mennyiségű véletlen szám van `1`-`interval` között, tehát kvázi készíts egy lottósorsoló programot. A sorrendre nem kell figyelni, a lényeg, hogy a számok __különbözők__ legyenek!

### Senior :x:

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

## 2020-12-16 (`week08d03`)

### Junior/Medior :heavy_check_mark:

Készíts `week08d03` csomagban egy `StringLists` osztályt és benne egy `stringListsUnion(List<String> first, List<String> second)` metódust, mely két string listát vár paraméterül és visszaadja az uniójukat. Az úniónak minden elemet tartalmaznia kell mindkét listából, de egy elem nem szerepelhet kétszer!

`"alma" != "Alma"`

`first: "a" "b" "c"`

`second: "a" "d"`

`unio: "a" "b" "c" "d"`

### Senior :x:

Készíts `week08d03` csomagban egy `StringLists` osztályt és benne egy `stringListsUnion(List<String> first, List<String> second)` metódust, mely két string listát vár paraméterül és visszaadja az uniójukat. Az úniónak minden elemet tartalmaznia kell mindkét listából, de egy elem nem szerepelhet kétszer! Feltételezhetjük, hogy az egyes listákban minden elem legfejebb egyszer fordul elő.

## 2020-12-17 (`week08d04`)

### Junior/Medior :heavy_check_mark: :x:
Hozz létre egy `CanMark` interfészt egy `int giveMark()` metódussal! Ez azt jelenti, hogy valaki
tud osztályzatot adni. Ennek legyen két implementációja, egy `GoodMood`
osztály, mely mindig `5` értéket ad vissza, és egy `BadMood` osztály, mely mindig `3` értéket ad vissza!
Azaz jó hangulatban valaki mindig ötöst ad, rossz hangulatban hármast.
Legyen egy `Trainer` osztály, melynek van egy `CanMark` attribútuma, mely konstruktorral állítható be! És
legyen egy `int giveMark()` metódusa, mely továbbhív, azaz "delegál" a `CanMark` példány felé!
Hozz létre a `main()` metódusban egy `Trainer` példányt, aki jó hangulatban van (azaz konstruktorban
adj át neki egy `GoodMood` példányt, és egy másikat, aki `BadMood` példányt kap! Majd hívd meg
a `giveMark()` metódusát mindkettőnek, és nézd meg, mit ad vissza!

### Senior :x:

Legyen a classpath-on egy `examples.md` fájl, mely a gyakorlati feladatok leírásait tartalmazza
a következő formátumban! A `ExamplesStore` osztályba írj egy `getTitlesOfExamples()`
metódust, mely visszaadja a feladatok címeit egy listában!

```
# Első feladat

Írj egy programot, amely
kiírja az összeadás eredményét!

# Második feladat

Írj egy programot,
mely kiírja a kivonás eredményét!
```

## 2020-12-18 (`week08d05`)

### Junior :heavy_check_mark:
A `week08d05` csomagban készíts egy osztályt `MathAlgorithms` néven. Legyen benne egy metódus, `greatestCommonDivisor()` , ami paraméterül vár két pozitív egész számot és visszaadja a legnagyobb közös osztójukat.

### Senior :x:
Egy repülőgéppel átszeljük az óceánt és a közben méréseket végzünk. Tudjuk, hogy partól indulunk és parthoz érünk. A méréseket adott időközönként egyenletesen végezzük. A mérések azt mutatják, hogy sziget vagy óceán fölött repülünk éppen. Az 1-es szigetet míg a 0 óceánt jelöl.
pl.: 111000010100001  sorozatban egy három "hosszú" sziget majd négy hosszú "óceán", aztán sziget, víz, sziget, majd óceán és végül egy szigeten leszálltunk. A `map.txt` állományban egy "térképet" tárolunk. A feladat az, hogy "repüljünk" a térkép fölött végig és határozzuk meg a leghosszabb óceán szakasz hosszát.
A térkép fölött csak egyszer repülhetünk el és amikor leszálltunk már tudnunk is kell az eredményt. (Magyarul ne olvasd be a file-t a memóriába) A feladatot a `week08d05.Plane` osztályba végezzük el.
A térkép: 10000000111110000000000001111111111000010000010000100000111111110000101000000000111110000000000000000100000001000000000000111111000000000100000000000011

## 2020-12-22 (`week09d02`)

### Junior/Medior/Senior :heavy_check_mark:

A `week09d02` csomagban készíts egy osztályt `FibCalculator` néven. Ennek legyen egy metódusa `long sumEvens(int bound)` néven. Ennek a metódusnak a feladata az, hogy összeadja a páros fibonacci számokat addig, amig a következő fibonacci szám nem nagyobb, mint `bound`, majd visszadja a végredményt.

## 2020-12-23 (`week09d03`)

### Junior/Medior/Senior :heavy_check_mark:

A mai feladatban Mikulásnak segítünk ajándékokat kiosztani. A `week09d03` csomagba  dolgozz. Készíts egy `Present` nevű enumot a következő felsorolókkal: `Toy`, `Electronic`, `Housekepping`, `Decoration`. Ezek fogják az ajándékok típusát reprezentálni. Készíts egy `Person` osztályt legyen neki neve és életkora és legyen egy `Present` típusú attribútuma. A nevet és életkort konstruktorban kapja meg. Legyen egy `setPresent()` metódusa ami beállítja az ajándék attribútumot véletlenszerűen, egy kitétel van, `14` év fölötti nem kaphat játékot. Ennek megvalósításához szabadon bővíthetőek az eddig elkészült elemek. Legyen egy `SantaClaus` osztály, akinek van egy `Person` listája, amit konstruktorban kap meg. Legyen neki egy `getThroughChimneys()` metódusa, ami végigmegy az emberek listáján és meghívja minden ember `setPresent()` metódusát.

## 2021-01-04 (`week10d01`)

### Junior/Medior :heavy_check_mark:

Túrázás közben egy GPS eszköz rögzíti a pontokat. Eltárolja a GPS koordinátákat, valamint a magasságot (mindegyik lebegőpontos érték).
Írj a `week10d01.Hiking` osztályba egy `getPlusElevation()` metódust, mely megkapja a magasságok listáját, és visszaadja
a emelkedések összegét. Azaz pl. `10,20,15,18` esetén `13`, ugyanis `(20 - 10) + (18 - 15)`. A `20` méterről `15` méterre ereszkedést nem számolja bele,
hiszen az ereszkedés, és nem emelkedés.

### Senior :heavy_check_mark: :x:

Túrázás közben egy GPS eszköz rögzíti a pontokat. Eltárolja a GPS koordinátákat, valamint a magasságot (mindegyik lebegőpontos érték).
Ezt egy fájlba tárolja, melynek formátuma:

```
47.497913, 19.040236, 400
47.497912, 19.040232, 420
47.497916, 19.040236, 410
```

Írj a `week10d01.HikingFile` osztályba egy `getPlusElevation()` metódust, mely kap egy `InputStream`-et, és visszaadja
külön az ereszkedések, és külön az emelkedések összegét. Azaz pl. `10,20,15,18` esetén az emelkedés `13`, ugyanis `(20 - 10) + (18 - 15)`.
A `20` méterről `15` méterre ereszkedést pedig `5`.

## 2021-01-05 (`week10d02`)

### Junior/Medior :heavy_check_mark:

Van egy egész számok listája, amelyben egy szám azt jelzi, hogy az adott számú buszmegállóban egy ember fel akar szállni. A `12,12,0,3,4,4` sorozat tehát azt jelenti, hogy a `12`-es buszmegállóban `2`-en, a `0`-ásban `1` ember, `3`-asban egy ember, `4`-esben `2` ember akar felszállni. A `MaxTravel` osztály `getMaxIndex()` metódusa adja vissza, hogy hanyas megállóban szeretnének a legtöbben felszállni. Maximum `30` megálló lehet.

ha két megállóban ugyanannyian akarnak felszállni, akkor az első megálló azonosítóját add vissza.

### Senior :x:

Adott egy fájl, `utasadat.txt`, mely a következőket tartalmazza:

```
0 20190326-0700 6572582 RVS 20210101
0 20190326-0700 8808290 JGY 7
0 20190326-0700 1680423 TAB 20190420
12 20190326-0716 3134404 FEB 20190301
12 20190326-0716 9529716 JGY 0
```

Ebből a megálló száma az első oszlop.

Feladat: írj egy `Travel.getStopWithMax(InputStream)` metódust, mely
visszaadja, hogy melyik megállóban szerettek volna a legtöbben
felszállni.

## 2021-01-08 (`week10d05`)

### Junior/Medior :heavy_check_mark: :x:

Készítsünk egy `Calculator` nevű osztályt, melynek van egy `findMinSum(int[] arr)` metódusa. A metódus feladata, hogy kiírja a legkisebb összegeket `4` számból, amiket lehetséges összerakni az arr tömb elemeiből. Példa: ha az arr tartalma `[1, 3, 5, 7, 9]`, akkor a minimum összeg `1+3+5+7=16`.

### Senior :x:

Készítsünk egy `Calculator` nevű osztályt, melynek van egy `findMinMaxSum(int[] arr)` metódusa. A metódus feladata, hogy kiírja a legnagyobb és a legkisebb összegeket `4` számból, amiket lehetséges összerakni az `arr` tömb elemeiből. Példa: ha az `arr` tartalma `[1, 3, 5, 7, 9]`, akkor a minimum összeg `1+3+5+7=16` , a maximum összeg `3+5+7+9=24`.
A `Calculator` osztály tartalmazzon egy `main` metódust is, amely a konzolról olvassa be a számokat és azokból készít tömböt, amivel meghívja a `findMinMaxSum` metódust.

## 2021-01-11 (`week11d01`)

### Junior/Medior :heavy_check_mark:

Készítsünk egy `DivisorFinder` nevű osztályt, melynek van egy `int findDivisors(int n)` metódusa. A feladat az, hogy megnézzük a szám minden egyes számjegyére, hogy osztója-e a számnak, majd számoljuk össze őket. Példa: a `425`-ben az `5` osztója a számnak, ezért a visszatérési érték `1`.

### Senior :x:

Készítsünk egy `PairFinder` nevű osztályt, melynek van egy `int findPairs(int[] arr)` metódusa. A feladat az, hogy a tömb elemeiből kikeressük, hogy hány darab pár van bennük. Ha egy szám kétszer szerepel a tömbben, akkor az egy párnak számít. Példa: A `[5, 1, 4, 5]` tömbben kétszer szerepel az 5, ezért a visszatérési érték `1`. A `[7, 1, 5, 7, 3, 3, 9, 7, 6, 7]` tömbben négyszer szerepel a 7, ezért ez 2 párnak számít, illetve a 3 kétszer szerepel, így a visszatérési érték `3`.

## 2021-01-12 (`week11d02`) Csoportmunka

### Junior/Medior :heavy_check_mark:

A feladatban egy biciklis futár egy heti munkáját rögzítjük és készítünk statissztikákat.

A futár minden fuvar után feljegyzi, hogy a hét hányadik napján történt a fuvar. Ezután azt, hogy az adott nap hányadik fuvarját teljesítette és ezután azt, hogy hány kilométer volt az adott fuvar. A futár egy-egy fuvarját reprezentálja a `Ride` nevű osztály, adatagokkal, konstruktorra, getterekkel.

Készítsd el a `Courier` osztályt. Ez fogja a futárt reprezentálni. Legyen egy rides listája ami fuvarokat tárol. Legyen egy addRide metódus, ami csak sorrendben enged hozzáadni elemeket a listához. Figyeljünk viszont arra, hogy nem feltétlenül minden nap dolgozott a futár, de ha már bekerült egy 3. napi fuvar, akkor ne kerülhessen be egy 2. napi. És arra is figyelj, hogy a napon belül is sorrendben kerüljenek be az adatok. Ha a paraméterül kapott Ride nem felel meg a feltételeknek dobjunk `IllegalArgumentException`-t.

pl egy helyes listára:
1 1 12
1 2 11
2 1 10
4 1 19

Készíts egy metódust, ami visszad egy napot amikor a futár nem dolgozott. Ha több ilyen nap is van akkor a korábbit!

### Senior :x:

A feladatban egy biciklis futár egy heti munkáját rögzítjük és készítünk statissztikákat.

A futár minden fuvar után feljegyzi, hogy a hét hányadik napján történt a fuvar. Ezután azt, hogy az adott nap hányadik fuvarját teljesítette és ezután azt, hogy hány kilométer volt az adott fuvar. A futár egy-egy fuvarját reprezentálja a `Ride` nevű osztály.

Készítsd el a `Courier` osztályt. Ez fogja a futárt reprezentálni. Legyen egy metódusa, ami a mellékelt fájl fuvarjait beolvassa és eltárolja a memóriában. Figyelem a fuvarok nem sorrendben vannak! (Készíts magadnak minta fájlt!)

Készíts egy metódust ami visszaadja a hét legelső fuvarjának minden adatát. Figyelj arra, hogy nem sorrendben vannak a fuvaraok és lehet, hogy nem is dolgozott az 1-es számú napon.
Készíts egy metódust, ami visszaadja valamilyen formában, hogy mely napokon nem dolgozott a futár!
Készíts egy metódust, ami visszaadja valamilyen formában napokra lebontva, hogy melyik nap hány kilométert tekert!

## 2021-01-13 (`week11d03`)

### Junior/Medior :x:

Készíts egy `WordFilter` osztályt, melyben van egy `List<String> wordsWithChar(List<String> words, char c)` metódus. A metódus kiválógatja a paraméterül kapott String listából azokat a szavakat, melyekben előfordul a c karakter, majd ezeket visszaadja egy listában.

### Senior :x:

Készítsünk egy `CharCounter` osztályt, melyben van egy `int countChars(String[] chars)` metódus. A feladat az, hogy összeszámoljuk azokat a karaktereket az összes `chars`-ban lévő `String`-ből, amelyek mindegyik `String`-ben szerepelnek. Példa: Ha a chars-ban `["abc", "cba", "ab"]` szerepel, akkor a visszatérési érték `2`, mert az `a` és a `b` karakter szerepel mindegyik `String`-ben.

## 2021-01-14 (`week11d04`)

### Junior/Medior :heavy_check_mark: :x:

Adott az aktuális könyvtárban több, fájl, melynek a nevei: `number00.txt`, `number03.txt`, `number20.txt`, egészen 99-ig.
Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az állományból a benne lévő
számot, és ezt összegezd! Használd a `Files.isRegularFile()` metódust arra, hogy megnézd, létezik-e a fájl!
Használd a `Files.readString()` metódust a fájl beolvasására! A `FilesSum` osztály `sumNumbers(InputStream)` metódusába dolgozz!

### Senior :x:

Adott egy nevek listája. Add vissza egy listában, hogy milyen hosszúságú `J` karakterrel kezdődő nevek szerepelnek a listában! Minden szám
csak egyszer szerepeljen! A `NameLength` osztály `getLengths(List<String>)` metódusába dolgozz!
Ha a bemenet pl. `List.of("Joe", "Jack", "Jane", "Jake", "George", "William")`, a visszatérési érték `[3, 4]` legyen!

## 2021-01-14 (`week12d01`)

### Junior/Medior :x:

Készíts egy `GradeRounder` osztályt, amiben van egy `int[] roundGrades(int[] grades)` metódus. A `grades` tömb pontszámokat tartalmaz `0` és `100` között. A feladat az, hogy kerekítsük a benne lévő számokat a következő szabály szerint: Ha a pontszám és az `5` következő többszöröse közötti különbség kisebb, mint `3`, akkor kerekítsük fel a számot az `5` következő többszörösére. Fontos: a `40` pont alatti pontszámok elégtelenek, ezeket egyáltalán nem kell kerekíteni. Példa: a pontszám `84`. `85 - 84` kevesebb mint `3`, így felfelé kerekítünk.

### Senior :x:

Készíts egy `GoodsPacker` osztályt, melynek van egy `int packGoods(int[][] types, int capacity)` metódusa. A `types` tömb számpárokat tartalmaz, melyek tárgyak súlyát és értékét tartalmazzák, például: `[(7, 160), (3, 90), (2, 15)]`. Az első szám a súly kilogrammban, a második szám az érték forintban. A feladat az, hogy kiszámoljuk, hogy a megadott táskamérethez (`capacity`) mennyi a tárgyak maximum értéke, amit belepakolhatunk a táskába. Például ha a `types` `[(7, 160), (3, 90), (2, 15)]` és a `capacity` `20`, akkor a maximum érték `555`.


