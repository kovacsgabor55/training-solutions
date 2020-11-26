package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SearchTest {
    private Search target;

    @BeforeEach
    void setUP() {
        target = new Search();
    }

    @Test
    void Given() {
        Assertions.assertEquals(Arrays.asList(1), target.getIndexesOfChar("ketchup", 'e'));
    }

    @Test
    void Given2() {
        Assertions.assertEquals(Arrays.asList(1, 3), target.getIndexesOfChar("kefe", 'e'));
    }
}
