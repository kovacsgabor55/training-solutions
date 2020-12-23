package week09d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testOverFourTeen() {
        Person p = new Person("John Doe", 16);
        p.setPresent();
        assertNotEquals(null, p.getPresent());
        assertNotEquals(Present.TOY, p.getPresent());
    }

    @Test
    void testUnderFourTenn() {
        Person p = new Person("John Doe", 12);
        p.setPresent();
        assertNotEquals(null, p.getPresent());
    }
}