package week13d02;

public class Catalog {
    private String flyNumber;
    private String direction;
    private String city;
    private int hours;
    private int minutes;

    public Catalog(String flyNumber, String direction, String city, int hours, int minutes) {
        this.flyNumber = flyNumber;
        this.direction = direction;
        this.city = city;
        this.hours = hours;
        this.minutes = minutes;
    }

    public String getFlyNumber() {
        return flyNumber;
    }

    public String getDirection() {
        return direction;
    }

    public String getCity() {
        return city;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "flyNumber='" + flyNumber + '\'' +
                ", direction='" + direction + '\'' +
                ", city='" + city + '\'' +
                ", hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}
