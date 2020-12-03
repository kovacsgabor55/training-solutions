package week06d04;

import java.util.Objects;

public class Item {
    private int price;
    private int month;
    private String name;

    public Item(int price, int month, String name) {
        Objects.requireNonNull(name, "Name cannot be null!");
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month should be between 1 and 12!");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than zero!");
        }
        this.price = price;
        this.month = month;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getMonth() {
        return month;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", month=" + month +
                ", name='" + name + '\'' +
                '}';
    }
}
