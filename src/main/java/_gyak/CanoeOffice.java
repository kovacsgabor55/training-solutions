package _gyak;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class CanoeOffice {
    private List<CanoeRental> canoeRentals;

    public void addRental(CanoeRental canoeRental) {
        canoeRentals.add(canoeRental);
    }

    public CanoeRental findRentalByName(String name) {
        int cr = canoeRentals.indexOf(name);
        if (isActive(canoeRentals.get(cr))) {
            return canoeRentals.get(cr);
        }
        return null;
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {
        CanoeRental cr = findRentalByName(name);
        if (cr != null) {
            cr.setEndTime(endTime);
        }
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental cr = findRentalByName(name);
        double tim = 0;
        if (cr != null) {
            tim = Duration.between(cr.getStartTime(), endTime).toHours() * cr.getCanoeType().getValue();
        }
        return tim;
    }

    public List<CanoeRental> listClosedRentals() {
        List<CanoeRental> result = new ArrayList<>();
        for (CanoeRental item : canoeRentals) {
            if (isInActive(item)) {
                result.add(item);
            }
        }
        Collections.sort(result);
        return result;
    }

    private boolean isActive(CanoeRental cr) {
        return cr.getEndTime() == null;
    }

    private boolean isInActive(CanoeRental cr) {
        return cr.getEndTime() != null;
    }

    public Map<CanoeType, Integer> countRentals() {
        Map<CanoeType, Integer> result = new HashMap<>();
        for (CanoeRental item : canoeRentals) {
            CanoeType ct = item.getCanoeType();
            if (result.get(ct) == null) {
                result.put(ct, 0);
            }
            result.put(ct, result.get(ct) + 1);
        }
        return result;
    }
}
