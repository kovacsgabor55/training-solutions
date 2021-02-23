package jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private final DataSource dataSource;

    public EmployeeDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long createEmployee(String name) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            return getIdByStatement(stmt);
        } catch (
                SQLException e) {
            throw new IllegalStateException("Cannot insert", e);
        }
    }

    public List<String> listEmployeeNames() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT emp_name FROM employees")
        ) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("emp_name");
                names.add(name);
            }
            return names;
        } catch (
                SQLException e) {
            throw new IllegalStateException("Cannot select employees", e);
        }
    }

    public String findEmployeeById(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT emp_name FROM employees WHERE id = ?")) {
            ps.setLong(1, id);
            return selectNameByPrepareStatement(ps);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot query", e);
        }
    }

    private String selectNameByPrepareStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("emp_name");
            }
            throw new IllegalArgumentException("Not Found");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot query", e);
        }
    }

    private long getIdByStatement(PreparedStatement stmt) {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new IllegalStateException("Cannot get id");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot get id", e);
        }
    }

    public void createEmployees(List<String> names) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)")) {
                for (String name : names) {
                    if (name.startsWith("x")) {
                        throw new IllegalArgumentException("Invalid name");
                    }
                    stmt.setString(1, name);
                    stmt.executeUpdate();
                }
                conn.commit();
            } catch (IllegalArgumentException iae) {
                conn.rollback();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert", e);
        }
    }
}
