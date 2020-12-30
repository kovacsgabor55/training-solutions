package timesheet;

public class Employee {
    private String firstname;
    private String lasttname;

    public Employee(String firstname, String lasttname) {
        this.firstname = firstname;
        this.lasttname = lasttname;
    }

    public String getName() {
        return firstname + " " + lasttname;
    }
}
