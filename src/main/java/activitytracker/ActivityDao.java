package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {
    private final DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO activities(start_time, activity_desc, activity_type) VALUES(?,?,?)")) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cannot insert", e);
        }

    }

    public Activity findActivityById(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM activities WHERE id=?")) {
            stmt.setLong(1, id);
            List<Activity> result = selectActivityByPreparedStatement(stmt);
            if (result.size() == 1) {
                return result.get(0);
            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }
    }

    public List<Activity> listActivities() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM activities")) {
            return selectActivityByPreparedStatement(stmt);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect", e);
        }
    }

    public List<Activity> selectByType(ActivityType type) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM activities WHERE activity_type=?")) {
            stmt.setString(1, type.toString());
            return selectActivityByPreparedStatement(stmt);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect", e);
        }
    }

    private List<Activity> selectActivityByPreparedStatement(PreparedStatement stmt) {
        List<Activity> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Activity activity = new Activity(rs.getLong("id"), rs.getTimestamp("start_time").toLocalDateTime(), rs.getString("activity_desc"), ActivityType.valueOf(rs.getString("activity_type")));
                result.add(activity);
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException("Execute failed!", e);
        }
    }
}
