package week07d01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {
    @DisplayName("Is prime number")
    @Test
    void isPrime() {
        assertEquals(true, MathAlgorithms.isPrime(2));
        assertEquals(true, MathAlgorithms.isPrime(3));
        assertEquals(true, MathAlgorithms.isPrime(5));
        assertEquals(true, MathAlgorithms.isPrime(31));
        assertEquals(true, MathAlgorithms.isPrime(1000003));
        assertEquals(true, MathAlgorithms.isPrime(100000000000031L));
    }

    @DisplayName("Is not prime number")
    @Test
    void isNotPrime() {
        assertEquals(false, MathAlgorithms.isPrime(1));
        assertEquals(false, MathAlgorithms.isPrime(9));
        assertEquals(false, MathAlgorithms.isPrime(4));
        assertEquals(false, MathAlgorithms.isPrime(10));
        assertEquals(false, MathAlgorithms.isPrime(16));
        assertEquals(false, MathAlgorithms.isPrime(25));
        assertEquals(false, MathAlgorithms.isPrime(341));
        assertEquals(false, MathAlgorithms.isPrime(561));
    }

    @DisplayName("Test zero number")
    @Test
    void isInvalidArgument() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.isPrime(0));
        assertEquals("Number cannot be zero or less!", ex.getMessage());
    }

    @DisplayName("Test less zero number")
    @Test
    void isInvalidArgument2() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.isPrime(-25));
        assertEquals("Number cannot be zero or less!", ex.getMessage());
    }
}