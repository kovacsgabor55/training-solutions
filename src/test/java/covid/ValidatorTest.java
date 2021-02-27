package covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void isValidNameTest() {
        assertTrue(validator.isValidName("Bal Bal"));
        assertTrue(validator.isValidName("   Bal Bal"));
        assertTrue(validator.isValidName("Bal Bal  "));
        assertTrue(validator.isValidName("  Bal Bal  "));
        assertTrue(validator.isValidName("balbal"));
        assertTrue(validator.isValidName("  balbal"));
        assertTrue(validator.isValidName("balbal   "));
        assertTrue(validator.isValidName("  balbal   "));
        assertTrue(validator.isValidName("balbal"));
        assertFalse(validator.isValidName(""));
        assertFalse(validator.isValidName("   "));
        assertFalse(validator.isValidName(null));
    }

    @Test
    void isValidMrTest() {
        assertTrue(validator.isValidMr("123456788"));
        assertTrue(validator.isValidMr("037687210"));
        assertFalse(validator.isValidMr("123456789"));
        assertFalse(validator.isValidMr("1234"));
        assertFalse(validator.isValidMr("abc"));
    }

    @Test
    void isValidEmailTest() {
        assertTrue(validator.isValidEmail("gmail@chucknorris.com"));
        assertTrue(validator.isValidEmail("webmaster@müller.de"));
        assertTrue(validator.isValidEmail("matteo@78.47.122.114"));
        assertFalse(validator.isValidEmail("@ghffg.com"));
        assertFalse(validator.isValidEmail("userinvalid.com"));
    }

    @Test
    void isValidAgeTest() {
        assertTrue(validator.isValidAge(11));
        assertTrue(validator.isValidAge(18));
        assertTrue(validator.isValidAge(110));
        assertTrue(validator.isValidAge(149));
        assertFalse(validator.isValidAge(150));
        assertFalse(validator.isValidAge(10));
        assertFalse(validator.isValidAge(-1));
        assertFalse(validator.isValidAge(0));
        assertFalse(validator.isValidAge(1));
        assertFalse(validator.isValidAge(9));
        assertFalse(validator.isValidAge(151));
        assertFalse(validator.isValidAge(351));
    }

    @Test
    void isValidZipTest() {
    }
}