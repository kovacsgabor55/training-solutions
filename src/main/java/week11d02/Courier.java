package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    private final List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        if (isAddable(ride)) {
            rides.add(ride);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int firstFreeDay() {
        boolean freeDay = true;
        for (int day = 1; day <= 7; day++) {
            for (Ride item : rides) {
                if (item.getDay() == day) {
                    freeDay = false;
                    break;
                }
            }
            if (freeDay) {
                return day;
            }
            freeDay = true;
        }
        return -1;
    }

    private boolean isAddable(Ride ride) {
        int last = rides.size() - 1;
        if (ride == null) {
            return false;
        }
        if (rides.isEmpty()) {
            return ride.getRideNr() == 1;
        }
        if (rides.get(last).getDay() > ride.getDay()) {
            return false;
        }
        if (rides.get(last).getDay() == ride.getDay()) {
            if (rides.get(last).getRideNr() >= ride.getRideNr()) {
                return false;
            } else if (rides.get(last).getRideNr() == ride.getRideNr() - 1) {
                return true;
            }
        }
        return ride.getRideNr() == 1;
    }
}
