package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {
    private final Boat boat;
    private final LocalDate sailing;
    private final double basicPrice;
    private final List<Passenger> passengers;

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
        this.passengers = new ArrayList<>();
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers() > passengers.size()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getValue() * basicPrice;
    }

    public Passenger findPassengerByName(String name) {
        Passenger passenger = null;
        for (Passenger item : passengers) {
            if (item.getName().equals(name)) {
                passenger = item;
            }
        }
        return passenger;
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> passengerNames = new ArrayList<>();
        for (Passenger item : passengers) {
            passengerNames.add(item.getName());
        }
        Collections.sort(passengerNames);
        return passengerNames;
    }

    public double sumAllBookingsCharged() {
        double sumPrice = 0;
        for (Passenger item : passengers) {
            sumPrice += getPriceForPassenger(item);
        }
        return sumPrice;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Passenger item : passengers) {
            CruiseClass key = item.getCruiseClass();
            if (!result.containsKey(key)) {
                result.put(key, 0);
            }
            result.put(key, result.get(key) + 1);
        }
        return result;
    }
}
