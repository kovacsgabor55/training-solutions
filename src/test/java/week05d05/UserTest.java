package week05d05;

import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals("Kiss", user1.getFirstName());
        Assertions.assertEquals("Arnold", user1.getLastName());
        Assertions.assertEquals("a@b.c", user1.getEmail());
    }

    @DisplayName("full name test")
    @Test
    void getFullNameTest() {
        Assertions.assertEquals("Kiss Arnold", user1.getFullName());

    }

    @DisplayName("no At test")
    @Test
    void noAtTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new User("", "", "");
        });
    }

}