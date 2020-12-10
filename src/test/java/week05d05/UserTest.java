package week05d05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    User user1;

    @DisplayName("Initialization")
    @BeforeEach
    void setUp() {
        user1 = new User("Kiss", "Arnold", "a@b.c");

    }

    @DisplayName("Constructor")
    @Test
    void constructorTest() {
        assertEquals("Kiss", user1.getFirstName());
        assertEquals("Arnold", user1.getLastName());
        assertEquals("a@b.c", user1.getEmail());
    }

    @DisplayName("full name test")
    @Test
    void getFullNameTest() {
        assertEquals("Kiss Arnold", user1.getFullName());

    }

    @DisplayName("no At test")
    @Test
    void noAtTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("", "", "");
        });
    }

}