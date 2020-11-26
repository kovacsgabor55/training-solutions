package finalmodifier;

public class TaxCalculator {
    static final double TAX = 27;

    public double tax(double price) {
        return price * TAX / 100;
    }

    double priceWithTax(double price) {
        return price + tax(price);
    }
}
