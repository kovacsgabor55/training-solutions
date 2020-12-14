package week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    Point point;

    @Test
    void step() {
        point = Point.of(4, 5).step(Point.of(2, 3));
        assertEquals(6, point.getX());
        assertEquals(8, point.getY());
    }

    @Test
    void of() {
        point = Point.of(4, 5);
        assertEquals(4, point.getX());
        assertEquals(5, point.getY());
    }
}