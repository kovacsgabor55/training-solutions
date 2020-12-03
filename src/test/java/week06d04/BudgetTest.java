package week06d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {
    List<Item> items;

    @BeforeEach
    void setUp() {
        items = Arrays.asList(new Item(1240, 5, "Mouse"),
                new Item(451, 4, "Bread"),
                new Item(154, 5, "Butter"),
                new Item(78, 9, "Goat")

        );
    }

    @DisplayName("Budget create test")
    @Test
    void createTest() {
        Budget budget = new Budget(items);
        Assertions.assertEquals(items, budget.getItems());
    }

    @DisplayName("Null list test")
    @Test
    void nullList() {
        Exception ex = assertThrows(NullPointerException.class, () -> new Budget(null));
        assertEquals("Item cannot be null!", ex.getMessage());
    }

    @Test
    void getItemsByMonth() {
        Budget budget = new Budget(items);
        Assertions.assertEquals("[Item{price=1240, month=5, name='Mouse'}, Item{price=154, month=5, name='Butter'}]", budget.getItemsByMonth(5).toString());
    }

    @DisplayName("To less month number")
    @Test
    void getItemsByMonthLessNumber() {
        Budget budget = new Budget(items);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> budget.getItemsByMonth(0));
        assertEquals("Month should be between 1 and 12!", ex.getMessage());
    }

    @DisplayName("To more month number")
    @Test
    void getItemsByMonthMoreNumber() {
        Budget budget = new Budget(items);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> budget.getItemsByMonth(13));
        assertEquals("Month should be between 1 and 12!", ex.getMessage());
    }
}