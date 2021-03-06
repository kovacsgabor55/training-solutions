package week06d02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class StoreTest {
    private Store store;

    @BeforeEach
    void setUp() {
        store = new Store(Arrays.asList(
                new Product("Virsli", Category.DAIRY, 2100),
                new Product("Füstőt kaubász", Category.BAKEDGOODS, 1400),
                new Product("Füstőt karaj", Category.BAKEDGOODS, 3800),
                new Product("Egri bikavér", Category.OTHER, 2300)
        ));
    }

    @Test
    void getProductsByCategory() {
        assertEquals("[FROZEN: 0, DAIRY: 1, BAKEDGOODS: 2, OTHER: 1]", store.getProductsByCategory());
    }

    @Test
    void getProductByCategoryName() {
        assertEquals(2, store.getProductByCategoryName(Category.BAKEDGOODS));
        assertEquals(1, store.getProductByCategoryName(Category.DAIRY));
        assertEquals(1, store.getProductByCategoryName(Category.OTHER));
        assertEquals(0, store.getProductByCategoryName(Category.FROZEN));
    }
}