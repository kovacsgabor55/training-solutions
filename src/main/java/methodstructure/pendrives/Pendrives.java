package methodstructure.pendrives;

import java.util.List;

public class Pendrives {
    public Pendrive best(List<Pendrive> pendrives) {
        Pendrive bestPrice = pendrives.get(0);
        for (Pendrive item : pendrives) {
            if (bestPrice.comparePricePerCapacity(item) == 1) {
                bestPrice = item;
            }
        }
        return bestPrice;
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        Pendrive cheapest = pendrives.get(0);
        for (Pendrive item : pendrives) {
            if (!cheapest.cheaperThan(item)) {
                cheapest = item;
            }
        }
        return cheapest;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive item : pendrives) {
            if (item.getCapacity() == capacity) {
                item.risePrice(percent);
            }
        }
    }
}
