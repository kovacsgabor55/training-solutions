package covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    FileManager fileManager;

    @BeforeEach
    void setUp() {
        fileManager = new FileManager();
    }

    @Test
    void loadCitizenToFile() throws IOException {
        List<Citizen> expected = List.of(
                new Citizen(0, "John Doe", 2063, 60, "john.doe@example.com", "123456788"),
                new Citizen(0, "Jane Doe", 2091, 40, "jane.doe@example.com", "037687210"));
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CitizenDAOTest.class.getResourceAsStream("registerExample.csv")))) {
            List<Citizen> actual = fileManager.loadCitizenToFile(reader);
            assertEquals(expected, actual);
        }
    }

    @Test
    void saveCitizenToFile() {
    }
}