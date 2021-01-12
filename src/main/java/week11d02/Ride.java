package week11d02;

public class Ride {
    private final int day;
    private final int rideNr;
    private final double length;

    public Ride(int day, int rideNr, double length) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException();
        }
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        if (rideNr < 1) {
            throw new IllegalArgumentException();
        }
        this.day = day;
        this.rideNr = rideNr;
        this.length = length;
    }

    public int getDay() {
        return day;
    }

    public int getRideNr() {
        return rideNr;
    }

    public double getLength() {
        return length;
    }
}
