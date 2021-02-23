package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class ActivityTrackerMain {
    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        ActivityDao activityDao = new ActivityDao(dataSource);
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 1, 12, 30), "Basketball in park", ActivityType.BASKETBALL));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 2, 23, 10, 20), "Biking in park", ActivityType.BIKING));
    }
}
