package week06d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    private Store store;

    @BeforeEach
    void setUp() {
        Product product1 = new Product("Virsli", Category.DAIRY, 2100);
        Product product2 = new Product("Füstőt kaubász", Category.BAKEDGOODS, 1400);
        Product product3 = new Product("Füstőt karaj", Category.BAKEDGOODS, 3800);
        Product product4 = new Product("Egri bikavér", Category.OTHER, 2300);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        store = new Store(products);
    }

    @Test
    void getProductByCategoryName() {
        Assertions.assertEquals("[FROZEN: 0, DAIRY: 1, BAKEDGOODS: 2, OTHER: 1]", store.getProductByCategoryName());
    }
}