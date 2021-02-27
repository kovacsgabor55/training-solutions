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

    public Activity saveActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO activities(start_time, activity_desc, activity_type) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
            long id = executeAndGetGeneratedKey(stmt);
            return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cannot insert", e);
        }
    }

    private long executeAndGetGeneratedKey(PreparedStatement stmt) {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new SQLException("No key was generated.");
        } catch (SQLException e) {
            throw new IllegalArgumentException("Insertion failed.", e);
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

    public List<Activity> insertActivities(List<Activity> activities) {
        List<Activity> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "insert into activities(start_time, activity_desc,activity_type) values(?,?,?)",
                     Statement.RETURN_GENERATED_KEYS
             )) {
            long id;
            for (Activity item : activities) {
                stmt.setTimestamp(1, Timestamp.valueOf(item.getStartTime()));
                stmt.setString(2, item.getDesc());
                stmt.setString(3, item.getType().toString());
                stmt.executeUpdate();
                id = executeAndGetGeneratedKey(stmt);
                result.add(new Activity(
                        id, item.getStartTime(), item.getDesc(), item.getType())
                );
            }
            return result;
        } catch (SQLException sqlException) {
            throw new IllegalArgumentException("Cannot insert", sqlException);
        }
    }

}
