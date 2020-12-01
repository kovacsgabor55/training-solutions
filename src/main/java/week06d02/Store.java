package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();

    public Store(List<Product> products) {
        this.products = products;
    }

    public String getProductsByCategory() {
        int count = 0;
        StringBuilder ret = new StringBuilder("[");
        Category[] categories = Category.values();
        for (Category cat : categories) {
            for (Product item : products) {
                if (item.getCategory() == cat) {
                    count++;
                }
            }
            ret.append(cat + ": " + count + ", ");
            count = 0;
        }
        ret.delete(ret.toString().length() - 2, ret.toString().length());
        ret.append("]");
        return ret.toString();
    }

    public int getProductByCategoryName(Category category) {
        int count = 0;
        for (Product item : products) {
            if (item.getCategory() == category) {
                count++;
            }
        }
        return count;
    }
}
