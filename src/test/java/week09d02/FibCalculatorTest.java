package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibCalculatorTest {

    @Test
    void sumEvens() {
        assertEquals(10, FibCalculator.sumEvens(8));
        assertEquals(44, FibCalculator.sumEvens(34));
    }
}