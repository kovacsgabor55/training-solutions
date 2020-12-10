package week06d04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @DisplayName("Item create test")
    @Test
    void constructorTest() {
        Item item = new Item(2500, 11, "Computer");
        assertEquals(2500, item.getPrice());
        assertEquals(11, item.getMonth());
        assertEquals("Computer", item.getName());

    }

    @DisplayName("To less month number")
    @Test
    void invalidMonthTest1() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Item(2500, 0, "Computer"));
        assertEquals("Month should be between 1 and 12!", ex.getMessage());
    }

    @DisplayName("To more month number")
    @Test
    void invalidMonthTest2() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Item(2500, 13, "Computer"));
        assertEquals("Month should be between 1 and 12!", ex.getMessage());
    }

    @DisplayName("Null name test")
    @Test
    void nullName() {
        Exception ex = assertThrows(NullPointerException.class, () -> new Item(2500, 11, null));
        assertEquals("Name cannot be null!", ex.getMessage());
    }

    @DisplayName("empty name test")
    @Test
    void emptyName() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Item(2500, 11, ""));
        assertEquals("Name cannot be empty!", ex.getMessage());
    }

    @DisplayName("Negative price test")
    @Test
    void negativePrice() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Item(-2500, 11, "Computer"));
        assertEquals("Price cannot be less than zero!", ex.getMessage());
    }
}