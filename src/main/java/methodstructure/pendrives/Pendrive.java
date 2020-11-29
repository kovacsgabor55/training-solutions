package methodstructure.pendrives;

public class Pendrive {
    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public void risePrice(int percent) {
        this.price += this.price * percent / 100;
    }

    public int comparePricePerCapacity(Pendrive other) {
        if (this.price / (double) this.capacity > other.price / (double) other.capacity) {
            return 1;
        } else if (this.price / (double) this.capacity < other.price / (double) other.capacity) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean cheaperThan(Pendrive other) {
        return (this.price < other.price);
    }
}

