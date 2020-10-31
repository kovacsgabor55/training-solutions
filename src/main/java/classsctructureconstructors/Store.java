package classsctructureconstructors;

public class Store {
    private String product;
    private int stock;

    public Store(String product) {
        this.product = product;
        this.stock = 0;
    }

    public void store(int amount) {
        this.stock += amount;
    }

    public void dispatch(int amount) {
        this.stock -= amount;
    }

    @Override
    public String toString() {
        return "Store{" +
                "product='" + product + '\'' +
                ", stock=" + stock +
                '}';
    }
}
