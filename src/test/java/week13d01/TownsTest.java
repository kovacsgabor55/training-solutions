package week13d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

public class TownsTest {

    @Test
    public void testLongestTownName() {
        Path path = Path.of("src/main/resources/iranyitoszamok-varosok-2021.csv");
        Assertions.assertEquals("Jászfelsőszentgyörgy", new Towns().longestTownName(path));
    }
}
