package week07d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {
    @DisplayName("Is prime number")
    @Test
    void isPrime() {
        Assertions.assertEquals(true, MathAlgorithms.isPrime(2));
        Assertions.assertEquals(true, MathAlgorithms.isPrime(3));
        Assertions.assertEquals(true, MathAlgorithms.isPrime(5));
        Assertions.assertEquals(true, MathAlgorithms.isPrime(31));
        Assertions.assertEquals(true, MathAlgorithms.isPrime(1000003));
        Assertions.assertEquals(true, MathAlgorithms.isPrime(100000000000031L));
    }

    @DisplayName("Is not prime number")
    @Test
    void isNotPrime() {
        Assertions.assertEquals(false, MathAlgorithms.isPrime(1));
        Assertions.assertEquals(false, MathAlgorithms.isPrime(9));
        Assertions.assertEquals(false, MathAlgorithms.isPrime(4));
        Assertions.assertEquals(false, MathAlgorithms.isPrime(10));
        Assertions.assertEquals(false, MathAlgorithms.isPrime(16));
        Assertions.assertEquals(false, MathAlgorithms.isPrime(25));
        Assertions.assertEquals(false, MathAlgorithms.isPrime(341));
        Assertions.assertEquals(false, MathAlgorithms.isPrime(561));
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