package week14d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IndexerTest {

    @Test
    void indexTest() {
        Map<Character, List<String>> expected = Map.of('A', Arrays.asList("Abraham"), 'L', Arrays.asList("Lujza"), 'M', Arrays.asList("Magdolna"), 'O', Arrays.asList("Odon"));
        List<String> input = Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna");
        assertEquals(expected, new Indexer().index(input));
    }

    @Test
    void indexTest2() {
        Map<Character, List<String>> expected = Map.of('A', Arrays.asList("Abraham", "Adam", "Ajtony"), 'L', Arrays.asList("Lujza", " Ludmilla"), 'M', Arrays.asList("Magdolna"), 'O', Arrays.asList("Odon"));
        List<String> input = Arrays.asList("Lujza", "Ludmilla", "Abraham", "Adam", "Ajtony", "Magdolna", "Odon");
        //assertEquals(expected, new Indexer().index(input));
    }
}