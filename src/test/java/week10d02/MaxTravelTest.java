package week10d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxTravelTest {
    @Test
    public void MaxTravelWorks() {
        assertEquals(3, MaxTravel.getMaxIndex(Arrays.asList(2, 2, 1, 3, 3, 3)));
        assertEquals(6, MaxTravel.getMaxIndex(Arrays.asList(2, 2, 1, 3, 3, 3, 6, 6, 6, 6, 6)));
        assertEquals(6, MaxTravel.getMaxIndex(Arrays.asList(2, 2, 1, 3, 3, 3, 6, 6, 6, 6, 6, 4, 4)));
    }
}