package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void findDivisors() {
        assertEquals(1, new DivisorFinder().findDivisors(425));
        assertEquals(1, new DivisorFinder().findDivisors(42));
        assertEquals(3, new DivisorFinder().findDivisors(424));
        assertEquals(2, new DivisorFinder().findDivisors(24));
        assertEquals(1, new DivisorFinder().findDivisors(1));
        assertEquals(1, new DivisorFinder().findDivisors(1));
        assertEquals(2, new DivisorFinder().findDivisors(404));
        assertEquals(0, new DivisorFinder().findDivisors(0));
    }
}