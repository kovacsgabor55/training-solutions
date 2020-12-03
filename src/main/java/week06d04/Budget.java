package week06d04;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Budget {
    private List<Item> items;

    public Budget(List<Item> items) {
        Objects.requireNonNull(items, "Item cannot be null!");
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Item> getItemsByMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month should be between 1 and 12!");
        }
        ArrayList<Item> ret = new ArrayList<>();
        for (Item item : items) {
            if (item.getMonth() == month) {
                ret.add(item);
            }
        }
        return ret;
    }
}
