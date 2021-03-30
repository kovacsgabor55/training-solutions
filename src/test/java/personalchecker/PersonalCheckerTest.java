package personalchecker;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonalCheckerTest {

    @Test
    void checkTAX() {
        assertTrue(PersonalChecker.isValidTaxNumber("8365670003", LocalDate.of(1967, 2, 13)));
    }

    @Test
    void cheX() {
        assertTrue(PersonalChecker.isValidSsn("123456788"));
        assertFalse(PersonalChecker.isValidSsn("123456789"));
    }

    @Test
    void testSsnLength() {
        assertFalse(PersonalChecker.isValidSsn("1234"));
    }

    @Test
    void testSsnLetters() {
        assertFalse(PersonalChecker.isValidSsn("abc"));
    }

    @Test
    void testSsnInvalidCrc() {
        assertFalse(PersonalChecker.isValidSsn("123456789"));
    }

    @Test
    void testSsnValidCrc() {
        assertTrue(PersonalChecker.isValidSsn("123456788"));
    }
}
