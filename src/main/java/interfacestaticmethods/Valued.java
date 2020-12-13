package interfacestaticmethods;

import java.util.List;

public interface Valued {

    static double totalValue(List<Valued> items) {
        double sum = 0;
        for (Valued item : items) {
            sum += item.getValue();
        }
        return sum;
    }

    double getValue();
}
