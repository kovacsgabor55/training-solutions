package finalmodifier;

public class TaxCalculator {
    final double TAX = 27;

    double tax(double price) {
        return price * TAX / 100;
    }

    double priceWithTax(double price) {
        return price + tax(price);
    }
}
