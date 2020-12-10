# Konzultációs feladatok

## 5. hét 2. nap (`week05d02`)

A `week05d02.ChangeLetter` osztályban írj meg egy `String changeVowels(String)` metódust, amely kicseréli a paraméterként átadott szövegben az angol magánhangzókat csillag karakterre.

## 5. hét 3. nap (`week05d03`)

### Junior/Mid level csoport gyakorlati feladata:

Írj egy olyan metódust az `week05d03.ListCounter` osztályban, mely egy kapott `List`ából (`String`) összeszámolja azokat amik `'a'` vagy `'A'` betűvel kezdődnek,
Ha nulla elemű a tömb, vagy nincs benne ilyen elem, akkor `0`-t adjon vissza.

### A Senior level csoport gyakorlati feladata:

Készíts egy osztályt `UserValidator` néven, mely rendelkezik egy `validate` nevű metódussal. A metódus `User` objektumok listáját várja és a feladata az, hogy ellenőrizze, hogy az `User` `name` attribútuma nem üres és az `User` `age` attribútuma nem negatív és nem nagyobb, mint `120`! Ha találunk egy nem megfelelő objektumot, akkor dobjunk el egy `InvalidArgumentException` kivételt, mely tartalmaz egy hibaüzenetet a validációs hiba okával!

## 5. hét 4. nap (`week05d04`)

### Junior/Mid level csoport gyakorlati feladata:

Készíts egy `week05d04.Product` osztályt amelyben egy termékről tárolod a nevét és a lejárati dátumát (`LocalDate`). Legyen egy konstruktora, ami a nevet kapja meg illetve a lejárati dátumot három részletben `int year, int month, int day`. (`public Product(String name, int year, int month, int day)`)
A lejárati dátumot a konstruktorban állítsd össze.
Legyen mindkettőhöz `get`ter metódus.
Készíts egy `week05d04.Store` osztályt, melyben van egy `Product`okat tároló lista. Legyen benne egy `addProduct(Product)` metódus.

__Bónusz:__ Legyen benne egy `getNumberOfExpired()` metódus ami visszaadja a lejárt termékek számát. Használd a `LocalDate.now()` és az `isBefore()` metódusokat.

### A Senior level csoport gyakorlati feladata:

Készíts egy osztályt `Product` néven, melynek van egy `price` (`long`) és egy `currency` (`String`) mezője. A `Product` a konstruktorában ellenőrizze a `currency` mezőt, melynek az értéke vagy `HUF`, vagy `USD` lehet.
Készíts egy metódust `convertPrice` néven, melynek egy paramétere van (`currency`) és visszaadja a `currency`-nek megfelelő összeget (`double`). Használjunk `300` forintos átváltási árfolyamot! Példa: ha a `Product`-ot létrehozzuk a következőképp: `new Product(150, "HUF")`, majd meghívjuk a `convertPrice`-ot "`USD`" paraméterrel, akkor az elvárt visszatérési érték `0.5`.

__Bónusz feladat:__ Használjunk `enum`-ot `String` helyett a pénznem reprezentációjára

## 5. hét 5. nap (`week05d05`)

### Junior/Mid level csoport gyakorlati feladata:

Készíts egy osztályt `week05d05.User` néven, melynek van egy `firstName (String)`, egy `lastName (String)` és egy `email (String)` mezője. Legyen ellenőrzés az `User` konstruktorában, mely hibát jelez, ha nincs `@` és `.` (pont) az e-mail címben! Készíts egy metódust is `getFullName` névvel, mely visszaadja a `firstName` és a `lastName` változókat összefűzve. Legyen köztük egy whitespace ("` `").

### A Senior level csoport gyakorlati feladata:

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

## 6. hét 1. nap (`week06d01`)

### Junior/Mid level csoport gyakorlati feladata:

Írj egy olyan metódust az `week06d01.ListSelector` osztályban, mely egy kapott listából minden második elemet kiválogat, és egy szövegként összerak, szögletes zárójelek között.
A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.
Ha üres a lista, akkor üres `String`et adjunk vissza. Ha a paraméterül kapott lista `null`, akkor dobjunk `IllegalArgumentException`t a metódusban.

### A Senior level csoport gyakorlati feladata:

Írj egy `week06d01.SeparatedSum.sum(String s)` metódust, amely kap egy `String`-et, melyben lebegőpontos számok szerepelnek pontosvesszővel elválasztva. A számoknál vessző a tizedes elválasztó. Ezt szétszedi, és összeadja külön a pozitív és külön a negatív számokat. Mivel térnél vissza ebből a metódusból?

## 6. hét 2. nap (`week06d02`)

### Junior/Mid level csoport gyakorlati feladata:

Hozz létre egy `week06d02.Product` osztályt amelynek adattagjai a név, kategória és ár, rendre, `String`, `String` `int`. Készíts egy `Store` osztályt benne egy `Product` listával, amit konstruktorban kap meg. Legyen egy `getProductByCategoryName(Category)`, ami visszaadja, hogy a paraméterül kapott kategóriából hány darab van a listában.

__Bónusz:__ A kategória legyen `enum` `FROZEN, DAIRY, BAKEDGOODS, OTHER` felsorolókkal.

### A Senior level csoport gyakorlati feladata:

Hozz létre egy `week06d02.Product` osztályt amelynek adattagjai a név, kategória és ár. A kategória legyen `enum` `FROZEN, DAIRY, BAKEDGOODS, OTHER` felsorolókkal. Készíts egy `Store` osztályt benne egy `Product` listával, amit konstruktorban kap meg. Legyen egy `getProductsByCategory()` aminek a lényege, hogy visszaadja valamilyen adatszerkezetben, hogy melyik kategóriából hány darab van a listában. A "valamilyen adatszerkezet" a kreativitásodra van bízva, az a lényeg, hogy valahogy egyben kapjam meg, hogy melyik kategóriából hány darab van. A `getProductsByCategory()` az összeset adja vissza.

## 6. hét 3. nap (`week06d03`)

### Junior/Mid level csoport gyakorlati feladata:

A `week06d03.WordEraser` osztályban legyen egy `eraseWord(String words, String word)` metódus, amely az első paraméter szöveget úgy változtatja meg, hogy a második paraméter összes előfordulását törli belőle. A `words` paraméterben a szavak szóközzel vannak elválasztva. A metódus térjen vissza a törölni kívánt szavak nélküli `String`gel. (Mellőzzük a `replace` és `replaceAll` használatát)

### A Senior level csoport gyakorlati feladata:

`week06d03.Series` osztályban hozz létre egy `calculateSeriesType` metódust, amely egész számok listáját kapja, és eldönti, hogy növekvő, csökkenő vagy össze-vissza sorozatról van-e szó! Feltétel, hogy a bemeneti lista nem tartalmaz egymás után egyenlő értékeket. Ha a lista üres, vagy csak egy elemből áll, dobj kivételt! Mivel térnél vissza?

## 6. hét 4. nap (`week06d04`)

### Junior/Mid level csoport gyakorlati feladata:

Készíts az `week06d04` csomagban egy `Budget` osztályt, amely a konstruktorában `Item` példányokat vár listában (`List`). Az `Item` tartalmazza az alábbi attribútumokat: `int price`, `int month`, `String name`. A `Budget` osztály tárolja el egy attribútumban a konstruktorban megkapott `items` listát. Írjunk egy metódust, `getItemsByMonth` néven, amely egy hónapot vár (`1`-`12`) és visszaadja az `Item`eket az adott hónapban!

__Bónusz feladat:__ ellenőrizzük a bemeneti paramétereket!

### A Senior level csoport gyakorlati feladata:

`week06d4.ShoppingCart` osztályba dolgozz! Legyen egy `addItem(String name, int quantity)` metódusa, mellyel új bevásárlólista tételt lehet felvenni (termék neve és mennyisége). Az adatokat egy `Item` listába tárolja. Amennyiben már benne van az adott termék, ne újonnan vegye fel, hanem adja hozzá a mennyiséget a már felvett tételhez. Lehessen visszakérdezni név alapján a felvett mennyiséget a `getItem(String name)`: `int` metódussal. Ha nem szerepel benne, `0` értéket adjon vissza.

## 6. hét 5. nap (`week06d05`)

### Junior/Mid level csoport gyakorlati feladata:

Készíts a `week06d05` csomagban egy `Biscuit` nevű osztályt, amelynek van 2 attribútuma: `BiscuitType type` és `int gramAmount`. A `BiscuitType` legyen felsorolásos típus a 3 kedvenc keksz fajtáddal. A `Biscuit` nevű osztálynak legyen egy `static` metódusa `of` néven, mely paraméterként egy `BiscuitType`-ot, és egy `int gramAmount`-ot vár és visszaad egy új `Biscuit` objektumot amelyet a megadott paraméterek alapján hoz létre.

__Bónusz feladat:__ konzolra írás esetén a Biscuit jelenítse meg a type és a gramAmount mezőket!

### A Senior level csoport gyakorlati feladata:

Készíts a `week06d05` csomagban egy `Bottle` nevű osztályt, amelynek van 2 attribútuma: `BottleType type` és `int filledUntil`. A `BottleType` legyen felsorolásos típus az alábbi értékekkel: `GLASS_BOTTLE` és `PET_BOTTLE`, . A `Bottle` nevű osztálynak legyen egy `static` metódusa `of` néven, mely paraméterként egy `BottleType`-ot vár és visszaad egy új `Bottle` objektumot amelyet a megadott paraméter alapján hoz létre. A `Bottle` osztálynak legyen egy `fill` metódusa, mely egy `int fillAmount` paramétert vár. A `fill` meghívása esetén végezzen ellenőrzést, hogy megtelt-e már a `Bottle` objektum. Az ehhez szükséges `int maximumAmount` mezőt a `BottleType` tartalmazza! Ha túlcsordul a `Bottle` objektum, akkor dobjunk kivételt!

## 7. hét 1. nap (`week07d01`)

### Junior/Mid level csoport gyakorlati feladata: :heavy_check_mark:

Készíts egy osztályt a `week07d01` csomagba `MathAlgorithms` néven. Ebben az osztályban legyen egy `isPrime(int x)` metódus ami a paraméterül kapott számról eldönti, hogy prím-e vagy sem és ennek megfelelően `true` vagy `false` értékkel tér vissza. Aki már tart ott és tudja mit jelent a `static` az nyugodtan implementálhatja a metódust statikus metódus ként. Az egyszerűség kedvért a prímeket most csak a pozitív egész számok körében értelmezzük, így __bónuszként__ rá lehet ellenőrizni, hogy `x>0`  és ha nem akkor kivételt dobni. Prímeknek tekintjük azokat számokat amelyek csak eggyel és önmagukkal oszthatók, tehát a `2`,`3`,`5`,`7`,`11`,`13` stb.

### A Senior level csoport gyakorlati feladata: :heavy_check_mark: :x: :heavy_check_mark:

Készíts egy osztályt a `week07d01` csomagba `Fibonacci` néven. Legyen benne egy `fib` metódus, ami egy `int n` paramétert vár. A visszatérési értékünk legyen egy `long` szám, ami az `n`-edik fibonacci számot tartalmazza. (A fibonacci szám az az az előző kettő fibonacci szám összege és az első két szám az `1`, `1`.

__Bónusz feladat:__ implementáljuk az algoritmust ciklus nélkül és mentsük el a részeredményeket egy statikus változóba.

__Pontosítás:__ Ha `n = 0`, akkor `0`-t adunk vissza, ha `n=1`, akkor `1`-et, ezért lesz a `2`. elem szintén `1`, mert `0 + 1 = 1`

## 7. hét 2. nap (`week07d02`)

### Junior/Mid level csoport gyakorlati feladata: :heavy_check_mark:

Készíts egy `week07d02.DigitSum` osztályt és benne `sumOfDigits(int x)` metódus amely visszaadja a paraméterül kapott szám számjegyeinek összegét! pl.: `123` esetén a visszatérési érték `6`.

### A Senior level csoport gyakorlati feladata: :heavy_check_mark: :x: :x:

Készítsünk a `week07d02` csomagba egy interfészt `User` néven. Az interfésznek legyen egy `String getUsername()`, egy `String getFirstName()`, egy `String getLastName()` és egy `String getFullName()` metódusa. Implementáljuk az `User` interfészt egy `UserImpl` nevű osztályba, mely konstruktor paraméterként várja az `username`, a `firstName` és a `lastName` paramétereket. A `getFullName` metódushoz adjunk az interfészben egy default implementációt!

__Bónusz feladat:__ Készítsünk egy statikus függvényt az `User` interfészben `of` néven, amely létrehoz egy új `User` típusú objektumot!

## 7. hét 3. nap (`week07d03`)

### Junior/Mid level csoport gyakorlati feladata: :heavy_check_mark:

A `week07d03` csomagban hozz létre egy `NumberList` osztályt. Ennek legyen egy metódusa `isIncreasing(List<Integer>)` mely egy számokból álló listát vár paraméterül és megnézi, hogy a listában a számok növekvő sorrendben szerepelnek-e és ennek megfelelően igaz vagy hamis értékkel tér vissza. Speciális eset ha két egymást követő szám egyenlő, ez nem probléma a `1`,`2`,`3`,`3`,`3`,`5` számokat növekvőnek tekintjük.

### A Senior level csoport gyakorlati feladata: :heavy_check_mark:

Készítsünk a `week07d03` csomagba egy `Date` osztályt, mely az alábbi attribútumokkal rendelkezik: `int year`, `int month`, `int day`. Az összes attribútum legyen `final`! Készítsünk továbbá egy statikus `of` metódust, mely a `year`, `month` és `day` paramétereket várja és létrehoz egy `Date` objektumot ezek alapján. Legyen továbbá a `Date`-nek egy `withYear(int year)`, `withMonth(int month)` és egy `withDay(int day)` metódusa, melyek egy új `Date` objektumot adnak vissza az eredeti `Date` objektum adataival, azzal a különbséggel, hogy az új objektum a megadott paraméter értékét tartalmazza a megfelelő helyen (`year`, `month` vagy `day`).

## 7. hét 4. nap (`week07d04`)

### Junior/Mid level csoport gyakorlati feladata: :heavy_check_mark:

Hozz létre egy `week07d04.Lab` nevű osztályt, ami azt tárolja el, hogy melyik feladattal készültél el. Három attribútuma: `title` ami a tananyag neve, egy `completed`, hogy elkészültél-e vele, és a `completedAt`, ami azt tárolja, hogy mikor. Legyen két konstruktora! Az egyik csak a címet várja, ekkor úgy állítsa be a példányt, hogy még nem készültél el. Legyen egy másik, ami várja a címet és a dátumot. Ekkor azt állítsa be, hogy elvégezted a gyakorlati feladatot. Írj egy `complete` metódust, ami kap egy dátumot, és beállítja, hogy elvégezted a gyakorlati feladatot. Legyen egy `complete` metódusa, ami semmit nem vár, ez azt állítja be, hogy MOST végezted el a gyakorlati feladatot. Írd meg a `toString` metódusát is!

### A Senior level csoport gyakorlati feladata: :x:

A `week07d04.ShoppingList` osztályba írj egy `long calculateSum(String path)` metódust, amely a paraméterként átadott fájlból beolvassa a bevásárlólista tartalmát, és összegzi az árat. A fájl a következő formátumú sorokat tartalmazza: `kenyér;2;30` ahol az első a termék neve, a második a darabszám, a harmadik az egységár. Azaz ezen sor esetén `2*30 = 60` értékkel kell számolni.
