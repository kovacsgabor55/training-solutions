package week07d03;

public class Date {
    private final int year;
    private final int month;
    private final int day;

    private Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static Date of(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return new Date(year, month, day);
    }

    public Date withMonth(int month) {
        return new Date(year, month, day);
    }

    public Date withDay(int day) {
        return new Date(year, month, day);
    }

    @Override
    public String toString() {
        return "Date{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
    }
}
