package debug;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees = new ArrayList<>();

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployeeByName(String name) {
        for (Employee item : employees) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public List<String> listEmployeeNames() {
        List<String> ret = new ArrayList<>();
        for (Employee item : employees) {
            ret.add(item.getName());
        }
        return ret;
    }
}
