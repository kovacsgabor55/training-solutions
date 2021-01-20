package timesheet2;

public class Employee {
    private String firstname;
    private String lastname;

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getName() {
        return firstname + " " + lastname;
    }
}
