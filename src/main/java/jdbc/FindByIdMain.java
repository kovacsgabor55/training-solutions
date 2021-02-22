package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByIdMain {

    public void selectNameByPrepareStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("emp_name");
                System.out.println(name);
            } else {
                throw new IllegalArgumentException("Not Found");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot query", e);
        }
    }

    public void selectNameById(DataSource ds, long id) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT emp_name FROM employees WHERE id = ?")) {
            ps.setLong(1, id);
            selectNameByPrepareStatement(ps);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot query", e);
        }
    }

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException e) {
            throw new IllegalStateException("Can not create data source", e);
        }
        new FindByIdMain().selectNameById(dataSource, 2);
    }
}
