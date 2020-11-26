package week03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OperationTest {

    @Test
    void testGetResult() {
        Operation operation = new Operation("161+18");
        assertEquals(179, operation.getResult());
    }
}