package week06d02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Virsli", Category.DAIRY, 2100);
    }

    @Test
    void getName() {
        assertEquals("Virsli", product.getName());
    }

    @Test
    void getCategory() {
        assertEquals(Category.DAIRY, product.getCategory());
    }

    @Test
    void getPrice() {
        assertEquals(2100, product.getPrice());
    }
}