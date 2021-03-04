package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizenDAOTest {
    private CitizenDAO citizenDAO;

    @BeforeEach
    void setUp() {
        DataSource config = new DatabaseConfig().getConfig();

        Flyway flyway = Flyway.configure().dataSource(config).load();
        flyway.clean();
        flyway.migrate();

        citizenDAO = new CitizenDAO(config);
    }

    @Test
    void insertCitizenTest() {
        Citizen citizen1input = new Citizen("John Doe", 2063, 60, "john.doe@example.com", "123456788");
        Citizen citizen2input = new Citizen("Jane Doe", 2091, 40, "jane.doe@example.com", "037687210");
        Citizen citizen1expected = new Citizen(1, "John Doe", 2063, 60, "john.doe@example.com", "123456788");
        Citizen citizen2expected = new Citizen(2, "Jane Doe", 2091, 40, "jane.doe@example.com", "037687210");
        Citizen citizen1 = citizenDAO.insertCitizen(citizen1input);
        Citizen citizen2 = citizenDAO.insertCitizen(citizen2input);
        assertEquals(citizen1expected, citizen1);
        assertEquals(citizen2expected, citizen2);
    }

    @Test
    void insertCitizensToFileTest() throws IOException {
        //TODO megirni normalisan
        List<Citizen> expected = List.of(
                new Citizen(1, "John Doe", 2063, 60, "john.doe@example.com", "123456788"),
                new Citizen(2, "Jane Doe", 2091, 40, "jane.doe@example.com", "037687210"));
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CitizenDAOTest.class.getResourceAsStream("registerExample.csv")))) {
            //List<Citizen> citizens = citizenDAO.loadCitizenToFile(reader);
            List<Citizen> actual = citizenDAO.insertCitizens(expected);
            assertEquals(expected, actual);
        }
    }

    @Test
    void generateCitizenVaccineWhitZipCodeTest() throws IOException {
       /* try (BufferedReader reader = new BufferedReader(new InputStreamReader(CitizenDAOTest.class.getResourceAsStream("MOCK_DATA.csv")))) {
            List<Citizen> citizens = citizenDAO.loadCitizenToFile(reader);
            List<Citizen> actual = citizenDAO.insertCitizens(citizens);
        }
        citizenDAO.generateCitizenVaccineWhitZipCode(6100, 16, 2, 15);*/
    }
}