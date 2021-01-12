package week11d02;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Courier {
    private List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        if (ride == null) {
            throw new IllegalArgumentException("ride canot be not null");
        }
        if (rides.isEmpty()) {
            rides.add(ride);
        }
        int last = rides.size() - 1;
        if (rides.get(last).getDay() <= ride.getDay()) {
            if (rides.get(last).getRideNr() < ride.getRideNr()) {
                rides.add(ride);
            }
        }
    }

    public int firstFreeDay() {
        boolean freeday = true;
        for (int day = 1; day <= 7; day++) {
            for (Ride item : rides) {
                if (item.getDay() == day) {
                    freeday = false;
                }
            }
            if (freeday) {
                return day;
            }
            freeday = true;
        }
        return -1;
    }

    public static void main(String[] args) {
        Courier cu = new Courier();
        Ride r1=new Ride(1,1,34.5);
        Ride r2=new Ride(2,1,34.5);
        Ride r3=new Ride(3,1,34.5);
        cu.addRide(r1);
        cu.addRide(r2);
        cu.addRide(r3);
        System.out.println(cu.firstFreeDay());
    }
}
