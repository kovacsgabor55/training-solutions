package stl_loader;

import java.nio.file.Path;

import static stl_loader.ManageSTL.*;

public class Main {
    static final Path cubeText = Path.of("src/main/resources/cubeText.stl");
    static final Path cubeBin = Path.of("src/main/resources/cubeBin.stl");
    static final Path outCubeTextToBin = Path.of("src/main/resources/outCubeTextToBin.stl");
    static final Path outCubeBinToText = Path.of("src/main/resources/outCubeBinToText.stl");
    static final Path outCubeText = Path.of("src/main/resources/outCubeText.stl");
    static final Path outCubeBin = Path.of("src/main/resources/outCubeBin.stl");

    public static void main(String[] args) {
        if (saveBinarySTL(outCubeTextToBin, loadSTL(cubeText))) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        if (saveTextSTL(outCubeBinToText, loadSTL(cubeBin))) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        if (saveBinarySTL(outCubeText, loadSTL(cubeText))) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        if (saveTextSTL(outCubeBin, loadSTL(cubeBin))) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        System.out.println(loadSTL(cubeBin).info());
        System.out.println(loadSTL(cubeText).info());

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
