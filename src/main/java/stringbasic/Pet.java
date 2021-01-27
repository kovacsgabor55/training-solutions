package stringbasic;

import java.time.LocalDate;

public class Pet {

    String name;
    LocalDate birth;
    String registrationNumber;
    GENDER gender;

    public Pet(String name, LocalDate birth, GENDER gender, String registrationNumber) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public GENDER getSex() {
        return gender;
    }
}