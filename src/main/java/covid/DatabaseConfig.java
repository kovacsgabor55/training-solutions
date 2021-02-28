package covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class DatabaseConfig {
    private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/vaccination_register?useUnicode=true";
    private static final String DATABASE_USER = "vaccination_register";
    private static final String DATABASE_PASSWORD = "vaccination_register";

    public MariaDbDataSource getConfig() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl(DATABASE_URL);
            dataSource.setUser(DATABASE_USER);
            dataSource.setPassword(DATABASE_PASSWORD);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
