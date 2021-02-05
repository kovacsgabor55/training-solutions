package AlgebricMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    Vector created;

    @BeforeEach
    void setUp() {
        created = new Vector(1, 2, 3, 4);
    }

    @Test
    void getOnesVectorTest() {
        Vector expected = new Vector(1, 1, 1, 1);
        assertEquals(expected, Vector.getOnesVector(4));
    }

    @Test
    void getNullVectorTest() {
        Vector expected = new Vector(0, 0, 0, 0);
        assertEquals(expected, Vector.getNullVector(4));
    }

    @Test
    void getAllElementsTest() {
        double[] excepted = {1, 2, 3, 4};
        assertArrayEquals(excepted, created.getAllElements());
    }

    @Test
    void getElementTest() {
        assertEquals(1, created.getElement(0));
        assertEquals(2, created.getElement(1));
        assertEquals(3, created.getElement(2));
        assertEquals(4, created.getElement(3));
    }

    @Test
    void getDimensionTest() {
        assertEquals(4, created.getDimension());
    }
}
