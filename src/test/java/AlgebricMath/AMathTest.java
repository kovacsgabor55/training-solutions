package AlgebricMath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AMathTest {

    @Test
    void vectorMultipleTest() {
        Vector input1 = new Vector(2, 2, 2, 2);
        Vector input2 = new Vector(3, 3, 3, 3);
        Vector excepted = new Vector(6, 6, 6, 6);
        assertEquals(excepted, AMath.vectorMultiple(input1, input2));
    }

    @Test
    void vectorMultipleTransposedTest() {
        Vector input1 = new Vector(2, 2, 2, 2);
        Vector input2 = new Vector(3, 3, 3, 3);
        assertEquals(24, AMath.vectorMultipleTransposed(input1, input2));
    }

    @Test
    void vectorMultipleInvalidDimensionTest() {
        Vector input1 = new Vector(2, 2, 2, 2);
        Vector input2 = new Vector(3, 3, 3);

        Exception ex = assertThrows(InvalidDimensionException.class, () -> AMath.vectorMultiple(input1, input2));
        assertEquals("v1 dimension=" + input1.getDimension() + " not equal v2 dimension=" + input2.getDimension() + ". " + input1.getDimension() + " \u2260 " + input2.getDimension(), ex.getMessage());
    }

    @Test
    void vectorMultipleTransposedInvalidDimensionTest() {
        Vector input1 = new Vector(2, 2, 2, 2);
        Vector input2 = new Vector(3, 3, 3);

        Exception ex = assertThrows(InvalidDimensionException.class, () -> AMath.vectorMultipleTransposed(input1, input2));
        assertEquals("v1 dimension=" + input1.getDimension() + " not equal v2 dimension=" + input2.getDimension() + ". " + input1.getDimension() + " \u2260 " + input2.getDimension(), ex.getMessage());
    }
}