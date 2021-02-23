package jdbc;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {
    private EmployeeDao employeeDao;

    @BeforeEach
    void setUp() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        employeeDao = new EmployeeDao(dataSource);
    }

    @Test
    void createEmployeeTest() {
        employeeDao.createEmployee("John Doe");
        assertEquals(Arrays.asList("John Doe"), employeeDao.listEmployeeNames());
    }

    @Test
    void byIdTest() {
        long id = employeeDao.createEmployee("Jack Doe");
        String name = employeeDao.findEmployeeById(id);
        assertEquals("Jack Doe", name);
    }

    @Test
    void createEmployeesTest() {
        List<String> names = Arrays.asList("Jack Doe", "Jane Doe", "Joe Doe");
        employeeDao.createEmployees(names);
        assertEquals(names, employeeDao.listEmployeeNames());
    }

    @Test
    void createEmployeesRollbackTest() {
        List<String> names = Arrays.asList("Jack Doe", "Jane Doe", "xJoe Doe");
        employeeDao.createEmployees(names);
        assertEquals(Collections.emptyList(), employeeDao.listEmployeeNames());
    }
}
