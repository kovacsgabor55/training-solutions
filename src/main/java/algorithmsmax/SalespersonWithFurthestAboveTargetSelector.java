package algorithmsmax;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons) {
        Salesperson maxTargetSalesPerson = null;
        for (Salesperson salesperson : salespersons) {
            if (maxTargetSalesPerson == null || salesperson.getDifferenceFromTarget() > maxTargetSalesPerson.getDifferenceFromTarget()) {
                maxTargetSalesPerson = salesperson;
            }
        }
        return maxTargetSalesPerson;
    }
}
