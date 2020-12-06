package introinheritance.basket;

public class ShoppingBasket {
    private Basket basket = new Basket();

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    // az összes tételre
    public double sumNettoPrice() {
        double sum = 0;
        for (Item item : basket.getItems()) {
            sum += item.getNettoPrice();
        }
        return sum;
    }

    // az összes tételre
    public double sumTaxValue() {
        double sum = 0;
        for (Item item : basket.getItems()) {
            sum += item.getTaxAmount();
        }
        return sum;
    }

    public double sumBruttoPrice() {
        double sum = 0;
        for (Item item : basket.getItems()) {
            sum += item.getNettoPrice() + item.getTaxAmount();
        }
        return sum;
    }

    // befejezzük a vásárlást, a kosár ürítése
    public void checkout() {
        basket = new Basket();
    }

    // kikeresi és eltávolítja a kosárból a legdrágább tételt
    public void removeMostExpensiveItem() {
        Item removable = basket.getItems().get(0);
        for (Item item : basket.getItems()) {
            if (item.getNettoPrice() > removable.getNettoPrice()) {
                removable = item;
            }
        }
        basket.removeItem(removable.getBarcode());
    }
}
