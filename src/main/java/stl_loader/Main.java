package stl_loader;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        if (ManageSTL.saveBinarySTL(Path.of("src/main/resources/out.stl"), ManageSTL.loadTextSTL(Path.of("src/main/resources/Sphericon.stl")))) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        if (ManageSTL.saveTextSTL(Path.of("src/main/resources/cubeText.stl"), ManageSTL.loadTextSTL(Path.of("src/main/resources/Sphericon.stl")))) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        ManageSTL.saveBinarySTL(Path.of("src/main/resources/cubeBin.stl"), ManageSTL.loadBinarySTL(Path.of("src/main/resources/teszt.stl")));


        ManageSTL.saveTextSTL(Path.of("src/main/resources/cubeText.stl"), ManageSTL.loadBinarySTL(Path.of("src/main/resources/teszt.stl")));
        ManageSTL.saveBinarySTL(Path.of("src/main/resources/cubeBin.stl"), ManageSTL.loadTextSTL(Path.of("src/main/resources/cubeText.stl")));
        ManageSTL.saveTextSTL(Path.of("src/main/resources/cubeText.stl"), ManageSTL.loadBinarySTL(Path.of("src/main/resources/cubeBin.stl")));

        /**
         *
         * Azt nem kezeli ha solid névvel kezdődik az objektum neve.
         * Ezek az esetek oda vissza konvertálásnál problémát jelenthetnek.
         * Bináris betöltő még nem kezeli ha van plusz információ a fáljba alapéterlemezettként úgy veszi hogy nincs ez byte torlodáshoz vezethet.
         * Nem ellenörzi a text betöltő hogy van -e nem odaillő sor azokat figyelmen kívül hagyja és a fájl vvégén se ellenőrzi a lezáró tagot
         * Több vertex esetén egy Facetben hozzáadja a többletet is.
         * Nem vizsgálja a betöltendő fájl integritását.
         * Nem vizsgálja hogy a név 80 bájt hossznál nem több-e
         */
    }
}
