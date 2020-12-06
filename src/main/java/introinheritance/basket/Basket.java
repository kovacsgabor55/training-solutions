package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {
        Item removable = null;
        for (Item item : items) {
            if (item.getBarcode().equals(barcode)) {
                removable = item;
                break;
            }
        }
        items.remove(removable);
    }

    //a Basket ürítése
    public void clearBasket() {
        items.clear();
    }

    // az Item lista másolatát adja vissza!
    public List<Item> getItems() {
        return List.copyOf(items);
    }
}
