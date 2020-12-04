package defaultconstructor.date;

public class SimpleDate {
    private int year, month, day;

    public void setDate(int year, int month, int day) {
        if (!isCorrect(year, month, day)) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied!");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    private boolean isCorrect(int year, int month, int day) {
        if (year < 1900 || day != calculateMonthLength(year, month)) {
            return false;
        }
        return true;
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0);
    }

    private int calculateMonthLength(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (isLeapYear(year)) ? 29 : 28;
            default:
                throw new IllegalArgumentException("One or more given parameter cannot be applied!");
        }
    }
}
