package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Store {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        Objects.requireNonNull(product, "Product can't be null.");
        products.add(product);
    }

    public int getNumberOfExpired() {
        int count = 0;
        LocalDate now = LocalDate.now();
        for (Product item : products) {
            if (item.getExpire().isBefore(now)) {
                count++;
            }
        }
        return count;
    }

    public List<Product> getProducts() {
        return products;
    }
}
