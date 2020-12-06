package introinheritance.basket;

public class Item {
    private String barcode;
    private double nettoPrice;
    private int vatPercent;

    public Item(String barcode, double nettoPrice, int vatPercent) {
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPercent = vatPercent;
    }

    // a nettoPrice és a vatPercent alapján kiszámolja az adó összegét
    public double getTaxAmount() {
        return nettoPrice * vatPercent / 100;
    }

    public double getNettoPrice() {
        return this.nettoPrice;
    }

    public String getBarcode() {
        return this.barcode;
    }

    // generált string reprezentáció
    @Override
    public String toString() {
        return "Item{" +
                "barcode='" + barcode + '\'' +
                ", nettoPrice=" + nettoPrice +
                ", vatPercent=" + vatPercent +
                '}';
    }
}
