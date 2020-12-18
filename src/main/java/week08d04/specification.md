## 8. hét 4. nap (`week08d04`)

### Junior/Mid level csoport gyakorlati feladata:
Hozz létre egy `CanMark` interfészt egy `int giveMark()` metódussal! Ez azt jelenti, hogy valaki
tud osztályzatot adni. Ennek legyen két implementációja, egy `GoodMood`
osztály, mely mindig `5` értéket ad vissza, és egy `BadMood` osztály, mely mindig `3` értéket ad vissza!
Azaz jó hangulatban valaki mindig ötöst ad, rossz hangulatban hármast.
Legyen egy `Trainer` osztály, melynek van egy `CanMark` attribútuma, mely konstruktorral állítható be! És
legyen egy `int giveMark()` metódusa, mely továbbhív, azaz "delegál" a `CanMark` példány felé!
Hozz létre a `main()` metódusban egy `Trainer` példányt, aki jó hangulatban van (azaz konstruktorban
adj át neki egy `GoodMood` példányt, és egy másikat, aki `BadMood` példányt kap! Majd hívd meg
a `giveMark()` metódusát mindkettőnek, és nézd meg, mit ad vissza! (edited)

### A Senior level csoport gyakorlati feladata:

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
