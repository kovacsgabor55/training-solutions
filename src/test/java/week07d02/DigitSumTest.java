package week07d02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitSumTest {

    @DisplayName("Positive or zero number test.")
    @Test
    void sumOfDigitsTest() {
        assertEquals(6, DigitSum.sumOfDigits(123));
        assertEquals(1, DigitSum.sumOfDigits(1));
        assertEquals(0, DigitSum.sumOfDigits(0));
    }

    @DisplayName("Negativ number test.")
    @Test
    void sumOfDigitsErrTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> DigitSum.sumOfDigits(-1));
        assertEquals("Number cannot less zero!", ex.getMessage());
    }
}