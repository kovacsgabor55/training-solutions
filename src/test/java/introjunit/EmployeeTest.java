package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    public void testCreate() {
        //Given
        Employee employee = new introjunit.Employee("John", 23);

        //When
        String resultName = employee.getName();

        //then
        assertEquals("John", resultName);
    }

    @Test
    public void testHaveBirthDay() {
        Employee employee = new Employee("Jack", 23);
        employee.haveBirthDay();
        assertEquals(24, employee.getAge());
    }
}
