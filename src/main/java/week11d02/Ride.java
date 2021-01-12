package week11d02;

public class Ride {
    private int day;
    private int rideNr;
    private double length;

    public Ride(int day, int rideNr, double length) {
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
