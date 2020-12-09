### A mai senior feladat:

`week06d4.ShoppingCart` osztályba dolgozz! Legyen egy `addItem(String name, int quantity)` metódusa, mellyel új bevásárlólista tételt lehet felvenni (termék neve és mennyisége). Az adatokat egy `Item` listába tárolja. Amennyiben már benne van az adott termék, ne újonnan vegye fel, hanem adja hozzá a mennyiséget a már felvett tételhez. Lehessen visszakérdezni név alapján a felvett mennyiséget a `getItem(String name)`: `int` metódussal. Ha nem szerepel benne, `0` értéket adjon vissza. _A teszt eseteket ne feledd!_

### Junior/Mid level csoport mai gyakorlati feladata:

Készíts az `week06d04` csomagban egy `Budget` osztályt, amely a konstruktorában `Item` példányokat vár listában (`List`). Az `Item` tartalmazza az alábbi attribútumokat: `int price`, `int month`, `String name`. A `Budget` osztály tárolja el egy attribútumban a konstruktorban megkapott `items` listát. Írjunk egy metódust, `getItemsByMonth` néven, mely egy hónapot vár (`1`-`12`) és visszaadja az `Item`eket az adott hónapban!

__Bónusz feladat:__ ellenőrizzük a bemeneti paramétereket és írjunk tesztet!
