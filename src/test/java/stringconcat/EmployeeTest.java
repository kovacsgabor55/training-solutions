package stringconcat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    /*@Rule
    ExpectedException exception = ExpectedException.none();

    @Test
    void testCreate() {
        Employee employee = new Employee("Kis Géza", "minőségellenőr", 520000);

        assertEquals("Kis Géza", employee.getName());
        assertEquals("minőségellenőr", employee.getJob());
        assertEquals(520000, employee.getSalary());
    }

    @Test
    void testCreateWithEmptyName() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Name must not be empty.");
        new Employee("", "minőségellenőr", 520000);
    }

    @Test
    void testCreateWithNullJob() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Job must not be empty.");
        new Employee("Kis Géza", null, 520000);
    }

    @Test
    void testCreateWithNegativeSalary() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Salary must be positive.");
        new Employee("Kis Géza", "minőségellenőr", -520000);
    }

    @Test
    void testToString() {
        Employee employee = new Employee("Kis Géza", "minőségellenőr", 520000);

        assertEquals("Kis Géza - minőségellenőr - 520000 Ft", employee.toString());
    }*/
}