package week05d05;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        Objects.requireNonNull(firstName, "Firt name cannot be null");
        Objects.requireNonNull(lastName, "Last name cannot be null");
        Objects.requireNonNull(email, "Email name cannot be null");
        this.firstName = firstName;
        this.lastName = lastName;
        int occurence = email.indexOf('@');
        System.out.println(occurence);
        if (occurence == -1 || email.substring(occurence).indexOf('.') == -1) {
            throw new IllegalArgumentException(String.format("Email address (%s) is invalid", email));
        }
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    private boolean isEmail(String email) {
        int tmp = email.indexOf('@');
        if (tmp != -1) {
            tmp = email.indexOf('.', tmp);
        }
        return (tmp != -1);
    }
}
