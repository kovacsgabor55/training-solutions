package covid;

import java.util.Objects;

public class Citizen {

    private final long id;
    private final String fullName;
    private final int zipCode;
    private final int age;
    private final String email;
    private final String medicalRecord;

    public Citizen(long id, String fullName, int zipCode, int age, String email, String medicalRecord) {
        Validator validator = new Validator();
        if (!validator.isValidName(fullName)) {
            throw new IllegalArgumentException("Name cannot be empty or blank!");
        }
        if (!validator.isValidZip(zipCode)) {
            throw new IllegalArgumentException("Invalid ZIP code! " + zipCode);
        }
        if (!validator.isValidAge(age)) {
            throw new IllegalArgumentException("Age must between 10 or 150! " + age);
        }
        if (!validator.isValidEmail(email)) {
            throw new IllegalArgumentException("E-mail most RFC822 pattern! " + email);
        }
        if (!validator.isValidMr(medicalRecord)) {
            throw new IllegalArgumentException("Medical Record is invalid! " + medicalRecord);
        }
        this.id = id;
        this.fullName = fullName.trim();
        this.zipCode = zipCode;
        this.age = age;
        this.email = email;
        this.medicalRecord = medicalRecord;
    }

    public Citizen(String fullName, int zipCode, int age, String email, String medicalRecord) {
        this(0L, fullName, zipCode, age, email, medicalRecord);
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return id == citizen.id && zipCode == citizen.zipCode && age == citizen.age && fullName.equals(citizen.fullName) && email.equals(citizen.email) && medicalRecord.equals(citizen.medicalRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, zipCode, age, email, medicalRecord);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", zipCode=" + zipCode +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", medicalRecord='" + medicalRecord + '\'' +
                '}';
    }
}
