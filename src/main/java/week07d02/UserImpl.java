package week07d02;

public class UserImpl implements User {
    private String username;
    private String firstName;
    private String lastName;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
}
