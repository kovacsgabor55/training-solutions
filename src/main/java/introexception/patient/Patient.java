package introexception.patient;

import java.util.Objects;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String ssn, int year) {
        Objects.requireNonNull(name);
        if (year < 1900 || !new SsnValidator().isValidSsn(ssn)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.socialSecurityNumber = ssn;
        this.yearOfBirth = year;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
