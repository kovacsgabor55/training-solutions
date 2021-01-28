package algorithmsmax;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons) {
        Salesperson maxSalesPerson = null;
        for (Salesperson salesperson : salespersons) {
            if (maxSalesPerson == null || salesperson.getAmount() > maxSalesPerson.getAmount()) {
                maxSalesPerson = salesperson;
            }
        }
        return maxSalesPerson;
    }
}
