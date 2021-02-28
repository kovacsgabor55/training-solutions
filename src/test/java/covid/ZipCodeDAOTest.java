package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeDAOTest {
    private ZipCodeDAO zipCodeDAO;

    @BeforeEach
    void setUp() {
        DataSource config = new DatabaseConfig().getConfig();

        Flyway flyway = Flyway.configure().dataSource(config).load();
        flyway.clean();
        flyway.migrate();

        zipCodeDAO = new ZipCodeDAO(config);
    }

    @Test
    void getCityTest() {
        assertEquals("Visegrád", zipCodeDAO.getCity(2025));
        assertEquals("Visegrád - Gizellatelep", zipCodeDAO.getCity(2026));
    }

    @Test
    void getCityFailTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> zipCodeDAO.getCity(9999));
        assertEquals("Not found", ex.getMessage());
    }
}