package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

public class EmployeesMain {
    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException e) {
            throw new IllegalStateException("Can not create data source", e);
        }
        EmployeeDao employeeDao = new EmployeeDao(dataSource);
        employeeDao.createEmployee("John Doe");
        List<String> names = employeeDao.listEmployeeNames();
        System.out.println(names);

        String name = employeeDao.findEmployeeById(4L);
        System.out.println(name);
    }
}
