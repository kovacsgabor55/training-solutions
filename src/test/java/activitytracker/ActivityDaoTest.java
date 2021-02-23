package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {
    ActivityDao activityDao;

    @BeforeEach
    void setUp() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }


    @Test
    void saveActivityTest() {
        /*
        Activity activity1=new Activity(LocalDateTime.of(2021,02,23,10,20),"Biking in Mátra",ActivityType.BIKING);
        Activity activity2=new Activity(LocalDateTime.of(2021,02,23,10,20),"Biking in Mátra",ActivityType.BIKING);
        Activity activity3=new Activity(LocalDateTime.of(2021,02,23,10,20),"Biking in Mátra",ActivityType.BIKING);
         */
    }

    @Test
    void findActivityByIdTest() {
        Activity activity = activityDao.findActivityById(1L);
        assertEquals(ActivityType.BIKING, activity.getType());
    }

    @Test
    void listActivitiesTest() {
    }
}
