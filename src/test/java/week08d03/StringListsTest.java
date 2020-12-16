package week08d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {
    List<String> first;
    List<String> second;
    List<String> union;

    @Test
    void stringListsUnion() {
        first = Arrays.asList("a", "b", "c");
        second = Arrays.asList("a", "d");
        union = Arrays.asList("a", "b", "c", "d");
        assertEquals(union, StringLists.stringListsUnion(first, second));
    }
}