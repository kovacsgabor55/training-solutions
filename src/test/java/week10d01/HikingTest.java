package week10d01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    void getPlusElevationTest() {
        assertEquals(13d, Hiking.getPlusElevation(new ArrayList<>(List.of(10d, 20d, 15d, 18d))));
    }
}