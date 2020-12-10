package week05d03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ListCounterTest {
    @Test
    void startWithATest() {
        ListCounter listCounter = new ListCounter();
        List<String> testList = Arrays.asList("Alma", "körte", "ananász", "kenyér");
        assertEquals(2, listCounter.startsWithACounter(testList));

    }

    @Test
    void startWithANonATest() {
        ListCounter listCounter = new ListCounter();
        List<String> testList = Arrays.asList("körte", "kenyér");
        assertEquals(0, listCounter.startsWithACounter(testList));

    }


}
