package week07d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberListTest {
    List<Integer> increase;
    List<Integer> noIncrease;
    List<Integer> oneNumber;
    List<Integer> empty;

    @BeforeEach
    void setUp() {
        increase = Arrays.asList(0, 1, 2, 3, 3, 4, 5, 6, 7, 7, 9, 12, 15, 17, 18, 18);
        noIncrease = Arrays.asList(0, 1, 2, 3, 3, 2, 5, 6, 7, 7, 9, 12, 15, 17, 18, 18);
        oneNumber = Arrays.asList(0);
        empty = Arrays.asList();
    }

    @DisplayName("Increase list")
    @Test
    void isIncreasingTest() {
        assertTrue(NumberList.isIncreasing(increase));
        assertTrue(NumberList.isIncreasing(oneNumber));
    }

    @DisplayName("No increase list")
    @Test
    void isNonIncreasingTest() {
        assertFalse(NumberList.isIncreasing(noIncrease));
    }

    @DisplayName("Empty list")
    @Test
    void isEmptyListTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> NumberList.isIncreasing(empty));
        assertEquals("Numbers cannot be empty!", ex.getMessage());
    }

    @DisplayName("Null")
    @Test
    void isNullTest() {
        Exception ex = assertThrows(NullPointerException.class, () -> NumberList.isIncreasing(null));
        assertEquals("Numbers cannot be null.", ex.getMessage());
    }
}