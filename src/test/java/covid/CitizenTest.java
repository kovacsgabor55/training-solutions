package covid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {

    @Test
    void constructorWithIdTest() {
        Citizen citizen = new Citizen(5L, "John Doe", 4521, 85, "john.doe@example.com", "123456788");
        assertEquals(5L, citizen.getId());
        assertEquals("John Doe", citizen.getFullName());
        assertEquals(4521, citizen.getZipCode());
        assertEquals(85, citizen.getAge());
        assertEquals("john.doe@example.com", citizen.getEmail());
        assertEquals("123456788", citizen.getMedicalRecord());
    }

    @Test
    void constructorWithoutIdTest() {
        Citizen citizen = new Citizen("John Doe", 4521, 85, "john.doe@example.com", "123456788");
        assertEquals("John Doe", citizen.getFullName());
        assertEquals(4521, citizen.getZipCode());
        assertEquals(85, citizen.getAge());
        assertEquals("john.doe@example.com", citizen.getEmail());
        assertEquals("123456788", citizen.getMedicalRecord());
    }
}
