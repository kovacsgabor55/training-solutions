# STL (fájlformátum)

Az STL a 3D Systems által létrehozott sztereolitográfiai CAD szoftverben honos fájlformátum. Az STL-nek számos háttere van, például a "Standard háromszög nyelv" és a "Standard Tessellation nyelv". Ezt a fájlformátumot számos más szoftvercsomag támogatja; széles körben használják gyors prototípus készítéshez, 3D nyomtatáshoz és számítógéppel segített gyártáshoz. Az STL fájlok csak egy háromdimenziós objektum felületi geometriáját írják le, a színek, a textúra vagy más gyakori CAD modellattribútumok ábrázolása nélkül. Az STL formátum mind az ASCII, mind a bináris ábrázolásokat meghatározza. A bináris fájlok gyakoribbak, mivel kompaktabbak.

Az STL fájl egy nyers, strukturálatlan háromszöget bezáró felületet ír le a háromszög normál egysége és csúcsai szerint (a jobb oldali szabály szerint rendezve) háromdimenziós derékszögű koordinátarendszer segítségével. Az eredeti specifikációban az összes STL-koordinátának pozitív számnak kellett lennie, de ez a korlátozás már nem érvényesül, és a negatív koordinátákkal manapság gyakran találkozunk az STL-fájlokban. Az STL fájlok nem tartalmaznak skála információt, és az egységek tetszőlegesek.

## ASCII STL

Az ASCII STL fájl a sorral kezdődik

```
solid név
```

ahol a _név_ opcionális karaktersorozat (bár ha a név el van hagyva, akkor a szilárd után szóköznek kell maradnia). A fájl tetszőleges számú háromszöggel folytatódik, mindegyiket az alábbiak szerint ábrázolva:

```
facet normal ni nj nk
    outer loop
        vertex v1x v1y v1z
        vertex v2x v2y v2z
        vertex v3x v3y v3z
    endloop
endfacet
```

ahol minden _n_ vagy _v_ egy lebegőpontos szám, előjel-mantissa- "e" -jel-kitevő formátumban, például: "2.648000e-002". Az irat a következővel zárul

```
endsolid név
```

A formátum felépítése arra enged következtetni, hogy más lehetőségek is léteznek (pl. Egynél több "loop" vagy háromnál több csúcsú hurkok). A gyakorlatban azonban minden oldal egyszerű háromszög.

A szóköz (szóközök, tabulátorok, új sorok) a fájlban bárhol használható, kivéve a számokat vagy szavakat. A "facet" és a "normal", valamint a "outer" és a "loop" közötti helyekre szükség van.

## Bináris STL

Mivel az ASCII STL fájlok nagyon naggyá válhatnak, létezik az STL bináris verziója. A bináris STL fájl 80 karakteres fejléccel rendelkezik (amelyet általában figyelmen kívül hagynak, de soha nem szabad "solid" betűvel kezdődnie, mert ez egyes szoftvereket feltételezheti, hogy ez egy ASCII STL fájl). A fejléc után egy 4 bájtos kis endián előjel nélküli egész szám jelzi a fájlban található háromszöges oldalak számát. Ezt követi az egyes háromszögeket egymás után leíró adatok. A fájl egyszerűen az utolsó háromszög után ér véget.

Mindegyik háromszöget tizenkét 32 bites lebegőpontos szám írja le: három a normál értékre, majd három az egyes csúcsok X/Y/Z koordinátáira - ugyanúgy, mint az STL ASCII verziója esetén. Ezek után következik egy 2 bájtos ("short") előjel nélküli egész szám, amely az "attribútum bájtok száma" - a szokásos formátumban ennek nullának kell lennie, mert a legtöbb szoftver nem ért semmit.

A lebegőpontos számok IEEE lebegőpontos számokként vannak ábrázolva, és feltételezzük, hogy azok kis végpontok, bár ezt a dokumentáció nem tartalmazza.

```
előjel nélküli egész 8 [80] - Fejléc
előjel nélküli egész 32 - Háromszögek száma

minden háromszögre
     valós 32 [3] - Normál vektor
     valós 32 [3] - 1. csúcs
     valós 32 [3] - 2. csúcs
     valós 32 [3] - 3. csúcs
     előjel nélküli egész 16 - attribútum bájtok száma (n)
     előjel nélküli egész 8 [n] - Extra attribútumadatok
vége
```

## Szín bináris STL-ben

Legalább két nem szabványos változat létezik a bináris STL formátumban a színinformációk hozzáadásához:

- A VisCAM és a SolidView szoftvercsomagok minden háromszög végén a két "attribútum byte count" bájtot használják egy 15 bites RGB szín tárolásához:
    - a 0–4 bit a kék intenzitási szintje (0–31),
    - az 5–9. bit a zöld intenzitási szintje (0–31),
    - a 10–14 bit a vörös intenzitási szintje (0 és 31 között),
    - A 15. bit 1, ha a szín érvényes, vagy 0, ha a szín nem érvényes (mint a normál STL fájloknál).
- A Materialize Magics szoftver a fájl tetején található 80 bájtos fejlécet használja az egész rész általános színének megjelenítésére. Ha színt használunk, akkor a fejlécben valahol az ASCII "COLOR =" karakterláncnak kell lennie, amelyet négy bájt követ, amely piros, zöld, kék és alfa csatornát (átlátszóság) képvisel a 0–255 tartományban. Ez az egész objektum színe, kivéve, ha az egyes oldalakon felülírják. A Magics anyagismeretet is felismer; részletesebb felületi jellemző. Közvetlenül a "COLOR = RGBA" specifikáció után legyen egy másik ASCII karakterlánc ", MATERIAL =", amelyet három szín követ (3 × 4 bájt): az első a diffúz visszaverődés színe, a második a tükrös kiemelés színe, a harmadik pedig egy ambient könnyű. Az anyagbeállításokat előnyben részesítik a szín helyett. A per-facet szín a két "attribútum byte count" bájtban az alábbiak szerint jelenik meg:
    - a 0–4 bit a vörös intenzitási szintje (0–31),
    - az 5–9. bit a zöld intenzitási szintje (0–31),
    - a 10–14. bit a kék intenzitási szintje (0–31),
    - A 15. bit 0, ha ennek a szempontnak megvan a maga egyedi színe, vagy 1, ha az objektumonkénti színt kell használni.

A két bájton belüli piros / zöld / kék sorrend megfordul ebben a két megközelítésben - tehát bár ezek a formátumok könnyen kompatibilisek lehetnek, a színek sorrendjének megfordítása azt jelenti, hogy nem - és ami még rosszabb, egy általános STL fájl az olvasó nem képes automatikusan megkülönböztetni őket. Az arculatok szelektíven átlátszóvá válásának sem lehet módja, mert nincs per-aspektus alfaérték - bár a jelenlegi gyors prototípus-készítő gépek kontextusában ez nem fontos.

## A facet normal

Az STL ASCII és bináris változatában egyaránt a normál aspektusnak a solid objektumtól kifelé mutató egységvektornak kell lennie. A legtöbb szoftverben ez a (0,0,0) értékre állítható, és a szoftver automatikusan kiszámítja a normál értéket a háromszög csúcsok sorrendje alapján a "jobbkezes szabály" segítségével. Néhány STL-betöltő (pl. Az Art of Illusion STL-bővítménye) ellenőrzi, hogy a fájlban szereplő normál megegyezik-e a jobboldali szabály alapján kiszámított normálissal, és figyelmeztetik a felhasználót, ha nem. Más szoftverek figyelmen kívül hagyhatják a normál szempontot, és csak a jobb oldali szabályt használhatják. Bár ritkán határoz meg olyan normál értéket, amelyet nem lehet a jobbkezes szabály alapján kiszámítani, a teljes hordozhatóság érdekében a fájlnak mind a normál szempontot meg kell adnia, mind a csúcsokat megfelelően kell rendeznie. Figyelemre méltó kivétel a SolidWorks, amely az árnyékolási effektusokhoz használja a normálist.

## Használja 3D nyomtatásban

A 3D nyomtatók objektumokat építenek egy réteg megszilárdításával. Ehhez egy sor zárt 2D kontúrra van szükség, amelyek megszilárdult anyaggal vannak feltöltve, miközben a rétegek összeolvadnak. Egy ilyen gép természetes fájlformátuma a különböző Z-értékeknek megfelelő zárt sokszögek sorozata lenne. Mivel azonban a rétegvastagságok változtathatók a gyorsabb, bár kevésbé precíz felépítés érdekében, könnyebb volt meghatározni a felépítendő modellt zárt poliéderként, amely a szükséges vízszintes szinteken szeletelhető.

Az STL fájlformátum úgy tűnik, hogy képes meghatározni a sokszöget bármilyen sokszögű nézettel, de a gyakorlatban ezt csak háromszögeknél használják, ami azt jelenti, hogy az ASCII protokoll szintaxisának nagy része felesleges.

A 3D kötet megfelelő kialakításához az STL fájlok által ábrázolt felületet le kell zárni és össze kell kötni, ahol minden él pontosan két háromszög része, és nem metszi egymást. Mivel az STL szintaxis nem kényszeríti ki ezt a tulajdonságot, figyelmen kívül hagyható azoknál az alkalmazásoknál, ahol a bezártság nem számít. A zártság csak annyiban számít, amennyiben a háromszögeket szeletelő szoftver megköveteli, hogy biztosítsa a kapott 2D sokszögek bezárását. Előfordul, hogy egy ilyen szoftvert meg lehet írni az apró eltérések megtisztítására az egymáshoz közeli csúcsok mozgatásával úgy, hogy egybeesjenek. Az eredmények nem kiszámíthatók, de gyakran elegendőek.

## Használja más mezőkben

Az STL fájlformátum egyszerű és könnyen kiadható. Következésképpen sok számítógéppel segített tervező rendszer képes kimenni az STL fájlformátumot. Bár a kimenet egyszerűen előállítható, a hálós kapcsolati információkat elvetjük, mert a megosztott csúcsok azonossága elvész.

Számos számítógéppel segített gyártási rendszer háromszög alakú modelleket igényel. Az STL formátum nem a memória és a számítás szempontjából leghatékonyabb módszer az adatok átadására, de az STL-t gyakran használják a háromszög alakú geometria importálására a CAM rendszerbe. A formátum általában elérhető, ezért a CAM rendszer fogja használni. Az adatok felhasználásához előfordulhat, hogy a CAM rendszernek rekonstruálnia kell a kapcsolatot. Mivel az STL fájlok nem menti az egység fizikai dimenzióját, egy CAM rendszer kéri. A tipikus egységek mm és hüvelyk.

Az STL használható adatcserére a CAD / CAM rendszerek és a számítási környezetek, például a Mathematica között is.

## Ívelt felületek ábrázolása

Háromszögekkel nem lehet tökéletesen ábrázolni az ívelt felületeket. A kompenzáció érdekében a felhasználók gyakran óriási STL fájlokat mentenek a pontatlanság csökkentése érdekében. A 3D tervező szoftver fájlok natív formátumai matematikai felületeket használnak a részletek veszteségmentes megőrzése érdekében a kis fájlokban.
