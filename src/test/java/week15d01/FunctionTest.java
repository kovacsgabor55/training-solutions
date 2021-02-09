package week15d01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    @Test
    void maxValueEntryTest() {
        Function graph = new Function();

        Map<Double, Double> function = new HashMap<>();

        function.put(-2.0, -1.0);
        function.put(-1.0, -7.0);
        function.put(0.0, -8.0);
        function.put(2.0, -1.5);
        function.put(1.0, -0.5);

        Map.Entry<Double, Double> result = graph.maxValueEntry(function);
        assertEquals(1.0, result.getKey());
        assertEquals(-0.5, result.getValue());
    }
}