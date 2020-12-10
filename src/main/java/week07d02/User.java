package week07d02;

public interface User {
    static User of() {
        return null;
    }

    String getUsername();

    String getFirstName();

    String getLastName();

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
