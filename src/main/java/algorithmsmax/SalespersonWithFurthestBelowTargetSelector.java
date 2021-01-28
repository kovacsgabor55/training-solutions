package algorithmsmax;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersons) {
        Salesperson minTargetSalesPerson = null;
        for (Salesperson salesperson : salespersons) {
            if (minTargetSalesPerson == null || salesperson.getDifferenceFromTarget() < minTargetSalesPerson.getDifferenceFromTarget()) {
                minTargetSalesPerson = salesperson;
            }
        }
        return minTargetSalesPerson;
    }
}
