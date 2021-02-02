package week14d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OnlineShoppingTest {
    private OnlineShopping on;

    @BeforeEach
    void init() {
        on = new OnlineShopping();
        on.loadFile("src/main/resources/data.txt");
    }

    @Test
    void loadFileTest() {
        assertEquals(9, on.getShoppingMap().size());
    }

    @Test
    void searchTest() {
        List<String> expected = List.of("corn", "hot_dog", "rolls");
        assertEquals(expected, on.search("A10"));
    }

    @Test
    void numberOfProductsTest() {
        assertEquals(3, on.getNumberByOrderedId("A10"));
    }

    @Test
    void productCounterTest() {
        assertEquals(2, on.getNumberOfOrderedProducts("tomato"));
    }

    @Test
    void listOfProductTest() {
        assertEquals(27, on.getProductsMap().size());
    }
}