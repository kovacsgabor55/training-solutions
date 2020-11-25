package week05d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ListCounterTest {
    @Test
    public void startWithATest() {
        ListCounter listCounter = new ListCounter();
        List<String> testList = Arrays.asList("Alma", "körte", "ananász", "kenyér");
        Assertions.assertEquals(2, listCounter.startsWithACounter(testList));

    }

    @Test
    public void startWithANonATest() {
        ListCounter listCounter = new ListCounter();
        List<String> testList = Arrays.asList("körte", "kenyér");
        Assertions.assertEquals(0, listCounter.startsWithACounter(testList));

    }


}
