package week08d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    void greatestCommonDivisorTest() {
        assertEquals(6, MathAlgorithms.greatestCommonDivisor(84, 18));
        assertEquals(6, MathAlgorithms.greatestCommonDivisor(18, 84));
        assertEquals(6, MathAlgorithms.greatestCommonDivisor(12, 18));
        assertEquals(5, MathAlgorithms.greatestCommonDivisor(10, 5));
        assertEquals(16, MathAlgorithms.greatestCommonDivisor(48, 80));
        assertEquals(40, MathAlgorithms.greatestCommonDivisor(120, 560));
        assertEquals(2, MathAlgorithms.greatestCommonDivisor(6, 8));
    }

    @Test
    void isInvalidOperandTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.greatestCommonDivisor(0, 0));
        assertEquals("a or b never used 0", ex.getMessage());
    }
}