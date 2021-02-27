package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizenDAOTest {
    private CitizenDAO citizenDAO;

    @BeforeEach
    void setUp() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/vaccination_register?useUnicode=true");
            dataSource.setUser("vaccination_register");
            dataSource.setPassword("vaccination_register");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        citizenDAO = new CitizenDAO(dataSource);
    }

    @Test
    void insertCitizenTest() {
        Citizen citizen1input = new Citizen("John Doe", 2063, 60, "john.doe@example.com", "123456788");
        Citizen citizen2input = new Citizen("Jane Doe", 2091, 40, "jane.doe@example.com", "037687210");
        Citizen citizen1expected = new Citizen(1L, "John Doe", 2063, 60, "john.doe@example.com", "123456788");
        Citizen citizen2expected = new Citizen(2L, "Jane Doe", 2091, 40, "jane.doe@example.com", "037687210");
        Citizen citizen1 = citizenDAO.insertCitizen(citizen1input);
        Citizen citizen2 = citizenDAO.insertCitizen(citizen2input);
        assertEquals(citizen1expected, citizen1);
        assertEquals(citizen2expected, citizen2);
    }

    @Test
    void insertCitizensToFileTest() throws IOException {
        List<Citizen> expected = List.of(
                new Citizen(1L, "John Doe", 2063, 60, "john.doe@example.com", "123456788"),
                new Citizen(2L, "Jane Doe", 2091, 40, "jane.doe@example.com", "037687210"));
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CitizenDAOTest.class.getResourceAsStream("registerExample.csv")))) {
            List<Citizen> citizens = citizenDAO.loadCitizenToFile(reader);
            List<Citizen> actual = citizenDAO.insertCitizens(citizens);
            assertEquals(expected, actual);
        }
    }

    @Test
    void insertCitizensToFileTest2() throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CitizenDAOTest.class.getResourceAsStream("MOCK_DATA.csv")))) {
            List<Citizen> citizens = citizenDAO.loadCitizenToFile(reader);
            List<Citizen> actual = citizenDAO.insertCitizens(citizens);
        }
    }

}