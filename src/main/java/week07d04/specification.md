### Mai senior feladat:

A `week07d04.ShoppingList` osztályba írj egy `long calculateSum(String path)` metódust, mely a paraméterként átadott fájlból beolvassa a bevásárlólista tartalmát, és összegzi az árat. A fájl a következő formátumú sorokat tartalmazza: `kenyér;2;30` ahol az első a termék neve, a második a darabszám, a harmadik az egységár. Azaz ezen sor esetén `2*30 = 60` értékkel kell számolni.

### Mai junior/mid-level feladat:

Hozz létre egy `week07d04.Lab` nevű osztályt, ami azt tárolja el, hogy melyik feladattal készültél el. Három attribútuma: `title` ami a tananyag neve, egy `completed`, hogy elkészültél-e vele, és a `completedAt` , ami azt tárolja, hogy mikor. Legyen két konstruktora! Az egyik csak a címet várja, ekkor úgy állítsa be a példányt, hogy még nem készültél el. Legyen egy másik, ami várja a címet és a dátumot. Ekkor azt állítsa be, hogy elvégezted a gyakorlati feladatot. Írj egy `complete` metódust, ami kap egy dátumot, és beállítja, hogy elvégezted a gyakorlati feladatot. Legyen egy `complete` metódusa, ami semmit nem vár, ez azt állítja be, hogy MOST végezted el a gyakorlati feladatot. Írd meg a `toString` metódusát is!
