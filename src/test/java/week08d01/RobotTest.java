package week08d01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    Robot robot;
    Point point;

    @BeforeEach
    void setUp() {
        robot = new Robot(Point.of(0, 0));
    }

    @Test
    void move() {
        point=robot.move("FFLLLLLBBBBJJJJJJJ");
        assertEquals(3,point.getX());
        assertEquals(-3,point.getY());
    }
    @Test
    void moveNonCaseSensitive() {
        point=robot.move("FfLLllLBBbBJJJjJJJ");
        assertEquals(3,point.getX());
        assertEquals(-3,point.getY());
    }

    @Test
    void moveOrigoToOrigo() {
        point=robot.move("FLBJ");
        assertEquals(0,point.getX());
        assertEquals(0,point.getY());
    }

    @Test
    void noMoveToOrigo() {
        point=robot.move("");
        assertEquals(0,point.getX());
        assertEquals(0,point.getY());
    }

    @Test
    void isNullCommandsTest() {
        Exception ex = assertThrows(NullPointerException.class, () -> robot.move(null));
        assertEquals("Command cannot be null String.", ex.getMessage());
    }

    @Test
    void isInvalidCommandsTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> robot.move("FFLLLLLBBHBBJJJJJJJ"));
        assertEquals("Invalid command: H", ex.getMessage());
    }
}