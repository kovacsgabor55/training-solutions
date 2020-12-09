### Mai Junior/Mid feladat:

Készíts egy osztályt `week05d05.User` néven, melynek van egy `firstName (String)`, egy `lastName (String)` és egy `email (String)` mezője. Legyen ellenőrzés az `User` konstruktorában, mely hibát jelez, ha nincs `@` és `.` (pont) az e-mail cimben! Készíts egy metódust is `getFullName` névvel, mely visszaadja a `firstName` és a `lastName` változókat összefűzve. Legyen közöttük egy whitespace ("` `").

__Bónusz feladat:__ írjunk teszteket

### Mai Senior feladat:

Készítsünk egy `Song` osztályt, melynek az alábbi mezői vannak:
- `String name`
- `long lengthInSeconds`
- `String artist`

A `Song` konstruktorában ellenőrizzük, hogy a `name` és az `artist` üres-e. Dobjunk kivételt, ha igen.
Ellenőrizzük továbbá a `lengthInSeconds`-ot is, hogy nagyobb legyen, mint `0`!
Készítsünk egy `Playlist` osztályt, melynek van egy konstruktora, amiben `Song`-ok `List`áját fogadja el.
Irjunk egy metódust `findByLengthGreaterThan` néven, mely egy `int`-et vár paraméterként `mins` néven.
Azoknak a `Song`-oknak a listáját adjuk vissza, melyek hosszabbak percben (!), mint a `Song` `lengthInSeconds` mezője.

__Bónusz feladat 1:__ írjunk teszteket!

__Bónusz feladat 2:__ Implementáljuk megfelelően a `toString` metódust a `Song` és a `Playlist` osztályban, hogy a `Playlist`et-et kiirva a konzolra olvasható eredményt kapjunk!
