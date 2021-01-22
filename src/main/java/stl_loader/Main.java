package stl_loader;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        /**
         *
         * Azt nem kezeli ha solid névvel kezdődik az objektum neve. (ez alapján döntheti el hogy miylen a formátum)
         * Ezek az esetek oda vissza konvertálásnál problémát jelenthetnek.
         * Bináris betöltő még nem kezeli ha van plusz információ a fáljba alapéterlemezettként úgy veszi hogy nincs ez byte torlodáshoz vezethet.
         * Nem ellenörzi a text betöltő hogy van -e nem odaillő sor azokat figyelmen kívül hagyja és a fájl vvégén se ellenőrzi a lezáró tagot
         * Több vertex esetén egy Facetben hozzáadja a többletet is.
         * Nem vizsgálja a betöltendő fájl integritását.
         * Nem vizsgálja hogy a név 80 bájt hossznál nem több-e
         */
        ManageSTL.loadBinarySTL(Path.of("src","main","resources","colored.stl"));
    }
}
