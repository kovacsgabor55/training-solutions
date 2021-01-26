package exceptionclass.course;

public class SimpleTime {
    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String timeStr) {
        if (timeStr == null) {
            throw new InvalidTimeException("Time is null");
        }
        try {
            String[] data = timeStr.split(":");
            int hour = Integer.parseInt(data[0]);
            int minute = Integer.parseInt(data[1]);
            if (hour < 0 || hour > 23) {
                throw new InvalidTimeException("Hour is invalid (0-23)");
            }
            if (minute < 0 || minute > 59) {
                throw new InvalidTimeException("Minute is invalid (0-59)");
            }
            this.hour = hour;
            this.minute = minute;
        } catch (NumberFormatException e) {
            throw new InvalidTimeException("Time is not hh:mm");
        }


    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}
