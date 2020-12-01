package week06d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Virsli", Category.DAIRY, 2100);
    }

    @Test
    void getName() {
        Assertions.assertEquals("Virsli", product.getName());
    }

    @Test
    void getCategory() {
        Assertions.assertEquals(Category.DAIRY, product.getCategory());
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(2100, product.getPrice());
    }
}