package stl_loader;

import java.nio.file.Path;

import static stl_loader.ManageSTL.*;

public class Main {
    public static void main(String[] args) {
        loadSTL(Path.of("src/main/resources/cubeText.stl"));
        if (saveBinarySTL(Path.of("src/main/resources/out.stl"), loadSTL(Path.of("src/main/resources/Sphericon.stl")))) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        if (saveTextSTL(Path.of("src/main/resources/cubeText.stl"), loadSTL(Path.of("src/main/resources/Sphericon.stl")))) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        saveBinarySTL(Path.of("src/main/resources/cubeBin.stl"), loadSTL(Path.of("src/main/resources/teszt.stl")));


        saveTextSTL(Path.of("src/main/resources/cubeText.stl"), loadSTL(Path.of("src/main/resources/teszt.stl")));
        saveBinarySTL(Path.of("src/main/resources/cubeBin.stl"), loadSTL(Path.of("src/main/resources/cubeText.stl")));
        saveTextSTL(Path.of("src/main/resources/cubeText.stl"), loadSTL(Path.of("src/main/resources/cubeBin.stl")));
        System.out.println(loadSTL(Path.of("src/main/resources/Sphericon.stl")).info());
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
    }
}
