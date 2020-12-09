### Mai feladat Junior/Mid-Level:

Készíts egy `week05d04.Product` osztályt melyben egy termékről tárolod a nevét és a lejárati dátumát (`LocalDate`). Legyen egy konstruktora, ami a nevet kapja meg illetve a lejárati dátumot három részletben `int year, int month, int day`. (`public Product(String name, int year, int month, int day)`)
A lejárati dátumot a konstruktorban állítsd össze.
Legyen mindkettőhöz `get`ter metódus.
Készíts egy `week05d04.Store` osztályt, melyben van egy `Product`okat tároló lista. Legyen benne egy `addProduct(Product)` metódus.

__Bónusz:__ Legyen benne egy `getNumberOfExpired()` metódus ami visszaadja a lejárt termékek számát. Használd a `LocalDate.now()` és az `isBefore()` metódusokat.
_Tesztelj!_

### Mai Senior feladat:

Készíts egy osztályt `Product` néven, melynek van egy `price` (`long`) és egy `currency` (`String`) mezője. A `Product` a konstruktorában ellenőrizze a `currency` mezőt, melynek az értéke vagy `HUF`, vagy `USD` lehet.
Készíts egy metódust `convertPrice` néven, melynek egy paramétere van (`currency`) és visszaadja a `currency`-nek megfelelő összeget (`double`). Használjunk `300` forintos átváltási árfolyamot! Példa: ha a `Product`-ot létrehozzuk a következőképp: `new Product(150, "HUF")`, majd meghívjuk a `convertPrice`-ot "`USD`" paraméterrel, akkor az elvárt visszatérési érték `0.5`.

__Bónusz feladat:__ írjunk teszteket

__Bónusz feladat 2:__ Használjunk `enum`-ot `String` helyett a pénznem reprezentációjára