package covid;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZipCodeDAO {
    private final DataSource dataSource;

    public ZipCodeDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<ZipCode> getAllZipCodes() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT zip_code, city, district FROM zip_codes")) {
            List<ZipCode> result = selectSettlementsPreparedStatement(stmt);

            if (result.isEmpty()) {
                throw new IllegalStateException("Cannot load zip codes");
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }
    }

    public String getCity(int zipCode) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT zip_code, city, district FROM zip_codes WHERE zip_code=?")) {
            stmt.setInt(1, zipCode);
            List<ZipCode> result = selectSettlementsPreparedStatement(stmt);
            if (!result.isEmpty()) {
                String city = result.get(0).getCity();
                String district = result.get(0).getDistrict();
                return (district.equals("")) ? city : city + " - " + district;
            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }
    }

    private List<ZipCode> selectSettlementsPreparedStatement(PreparedStatement stmt) {
        List<ZipCode> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(new ZipCode(rs.getInt("zip_code"), rs.getString("city"), rs.getString("district")));
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException("Execute failed!", e);
        }
    }
}
