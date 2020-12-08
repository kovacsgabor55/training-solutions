package week07d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DigitSumTest {

    @DisplayName("Positive or zero number test.")
    @Test
    void sumOfDigitsTest() {
        Assertions.assertEquals(6, DigitSum.sumOfDigits(123));
        Assertions.assertEquals(1, DigitSum.sumOfDigits(1));
        Assertions.assertEquals(0, DigitSum.sumOfDigits(0));
    }

    @DisplayName("Negativ number test.")
    @Test
    void sumOfDigitsErrTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> DigitSum.sumOfDigits(-1));
        assertEquals("Number cannot less zero!", ex.getMessage());
    }
}