package stl_loader;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static stl_loader.GraphicMath.*;

class GraphicMathTest {
    Vertex v1, v2, v3, v4, v5, v6, v7, v8;
    Vector nn001, nn010, nn100, ni001, ni010, ni100;

    @BeforeEach
    void setUp() {
        v7 = new Vertex(-12.7f, -12.7f, 0.0f);
        v1 = new Vertex(-12.7f, -12.7f, 25.4f);
        v4 = new Vertex(-12.7f, 12.7f, 0.0f);
        v3 = new Vertex(-12.7f, 12.7f, 25.4f);
        v8 = new Vertex(12.7f, -12.7f, 0.0f);
        v2 = new Vertex(12.7f, -12.7f, 25.4f);
        v6 = new Vertex(12.7f, 12.7f, 0.0f);
        v5 = new Vertex(12.7f, 12.7f, 25.4f);
        ni100 = new Vector(-1.0f, 0.0f, 0.0f);
        ni010 = new Vector(0.0f, -1.0f, 0.0f);
        ni001 = new Vector(0.0f, 0.0f, -1.0f);
        nn001 = new Vector(0.0f, 0.0f, 1.0f);
        nn010 = new Vector(0.0f, 1.0f, 0.0f);
        nn100 = new Vector(1.0f, 0.0f, 0.0f);
    }

    @Test
    @DisplayName("One normalized vector calculator")
    void calculateNormalVectorTest() {
        assertEquals(nn001, calculateNormalVector(v1, v2, v3));
        assertEquals(ni100, calculateNormalVector(v4, v1, v3));
        assertEquals(nn010, calculateNormalVector(v3, v5, v4));
        assertEquals(nn010, calculateNormalVector(v4, v5, v6));
        assertEquals(ni001, calculateNormalVector(v4, v6, v7));
        assertEquals(ni001, calculateNormalVector(v7, v6, v8));
        assertEquals(ni010, calculateNormalVector(v7, v8, v1));
        assertEquals(nn100, calculateNormalVector(v5, v8, v6));
        assertEquals(nn100, calculateNormalVector(v2, v8, v5));
        assertEquals(ni100, calculateNormalVector(v7, v1, v4));
        assertEquals(nn001, calculateNormalVector(v3, v2, v5));
        assertEquals(ni010, calculateNormalVector(v1, v8, v2));
    }
}