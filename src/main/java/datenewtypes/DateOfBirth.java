package datenewtypes;

import java.time.LocalDate;
import java.util.Locale;

public class DateOfBirth {
    LocalDate date;

    public DateOfBirth(int year, int month, int day) {
        date = LocalDate.of(year, month, day);
    }

    public DateOfBirth(String datestr, String pattern, Locale locale) {
        if (pattern.isEmpty() || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
    }

    public DateOfBirth(String datestr, String pattern) {
        if (pattern.isEmpty() || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return null;
    }

    public LocalDate getDateOfBirth() {
        return null;
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate later) {
        return null;
    }

    public int countDaysSinceBirth(LocalDate now) {
        if (this.date.isAfter(now)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        return 0;
    }

    public int countDaysBetween(DateOfBirth dateOfBirth) {
        return 0;
    }

    public String toString(String pattern) {
        if (pattern.isEmpty() || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        return null;
    }
}
