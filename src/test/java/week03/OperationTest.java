package week03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OperationTest {

    @Test
    public void testGetResult() {
        Operation operation = new Operation("161+18");
        assertEquals(179, operation.getResult());
    }
}