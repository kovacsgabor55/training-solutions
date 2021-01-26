package methoverloading;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this(hours, minutes, 0);
    }

    public Time(int hours) {
        this(hours, 0, 0);
    }

    public Time(Time time) {
        this(time.hours, time.minutes, time.seconds);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isEqual(Time time) {
        return (this.hours == time.hours && this.minutes == time.minutes && this.seconds == time.seconds);
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        return (this.hours == hours && this.minutes == minutes && this.seconds == seconds);
    }

    public boolean isEarlier(Time time) {
        if (this.hours < time.hours) {
            return true;
        } else if (this.minutes < time.minutes) {
            return true;
        } else {
            return (this.seconds < time.seconds);
        }
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        if (this.hours < hours) {
            return true;
        } else if (this.minutes < minutes) {
            return true;
        } else {
            return (this.seconds < seconds);
        }
    }
}
