package covid;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAO {
    private final DataSource dataSource;

    public CitizenDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Citizen insertCitizen(Citizen citizen) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO citizens(citizen_name, zip_code, age, email,medical_record) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, citizen.getFullName());
            stmt.setLong(2, citizen.getZipCode());
            stmt.setLong(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getMedicalRecord());
            stmt.executeUpdate();
            long id = executeAndGetGeneratedKey(stmt);
            return new Citizen(id, citizen.getFullName(), citizen.getZipCode(), citizen.getAge(), citizen.getEmail(), citizen.getMedicalRecord());
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

    private List<Long> executeAndGetGeneratedKeys(PreparedStatement stmt) {
        List<Long> result = new ArrayList<>();
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            while (rs.next()) {
                result.add(rs.getLong(1));
            }
            return result;
            //throw new SQLException("No key was generated.");
        } catch (SQLException e) {
            throw new IllegalArgumentException("Insertion failed.", e);
        }
    }

    public List<Citizen> insertCitizens(List<Citizen> citizens) {
        if (citizens.isEmpty()) {
            throw new IllegalArgumentException("Citizens list cannot be empty");
        }
        List<Citizen> result = new ArrayList<>();
        String sql = "INSERT INTO citizens(citizen_name, zip_code, age, email, medical_record) VALUES" + "(?,?,?,?,?),".repeat(citizens.size());
        sql = sql.substring(0, sql.length() - 1);
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     sql,
                     Statement.RETURN_GENERATED_KEYS
             )) {
            conn.setAutoCommit(false);
            int count = 0;
            for (Citizen item : citizens) {
                stmt.setString(1 + count, item.getFullName());
                stmt.setLong(2 + count, item.getZipCode());
                stmt.setLong(3 + count, item.getAge());
                stmt.setString(4 + count, item.getEmail());
                stmt.setString(5 + count, item.getMedicalRecord());
                count += 5;
            }
            stmt.executeUpdate();
            List<Long> id = executeAndGetGeneratedKeys(stmt);
            for (int i = 0; i < citizens.size(); i++) {
                result.add(new Citizen(id.get(i), citizens.get(i).getFullName(), citizens.get(i).getZipCode(), citizens.get(i).getAge(), citizens.get(i).getEmail(), citizens.get(i).getMedicalRecord()));
            }
            conn.commit();
            return result;
        } catch (Exception sqlException) {
            //conn.rollback();
            throw new IllegalArgumentException("Cannot insert", sqlException);
        }
    }

    public List<Citizen> loadCitizenToFile(BufferedReader reader) {
        List<Citizen> result = new ArrayList<>();
        try {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String name = data[0];
                int zip = Integer.parseInt(data[1]);
                int age = Integer.parseInt(data[2]);
                String email = data[3];
                String mr = data[4];
                result.add(new Citizen(name, zip, age, email, mr));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Something happened!");
        }
        return result;
    }

    private void saveCitizenToFile(List<Citizen> citizens, int zipCode) {
        LocalTime time = LocalTime.of(8, 0);
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(zipCode + ".csv"))) {
            bw.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
            for (Citizen item : citizens) {
                bw.write(String.format("%02d", time.getHour()));
                bw.write(":");
                bw.write(String.format("%02d", time.getMinute()));
                bw.write(";");
                bw.write(item.getFullName());
                bw.write(";");
                bw.write(String.valueOf(item.getZipCode()));
                bw.write(";");
                bw.write(String.valueOf(item.getAge()));
                bw.write(";");
                bw.write(item.getEmail());
                bw.write(";");
                bw.write(item.getMedicalRecord());
                bw.newLine();
                time = time.plusMinutes(30);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot save file", e);
        }
    }

    private List<Citizen> getAmountCitizenByZipCode(int zipCode, int amount, int maxVaccination, int dayOffset) {
        List<Citizen> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM citizens WHERE zip_code = ? AND number_of_vaccination < ? AND (last_vaccination is NULL OR DATE_ADD(last_vaccination, INTERVAL ? DAY) < CURRENT_DATE()) ORDER BY age DESC, citizen_name ASC LIMIT ?")) {
            stmt.setInt(1, zipCode);
            stmt.setInt(2, maxVaccination);
            stmt.setInt(3, dayOffset);
            stmt.setInt(4, amount);
            return result = selectCitizensPreparedStatement(stmt);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }
    }

    private List<Citizen> selectCitizensPreparedStatement(PreparedStatement stmt) {
        List<Citizen> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("citizen_id");
                String name = rs.getString("citizen_name");
                int zip = rs.getInt("zip_code");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String mr = rs.getString("medical_record");
                result.add(new Citizen(id, name, zip, age, email, mr));
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException("Execute failed!", e);
        }
    }

    public void generateCitizenVaccineWhitZipCode(int zipCode, int amount, int maxVaccination, int dayOffset) {
        saveCitizenToFile(getAmountCitizenByZipCode(zipCode, amount, maxVaccination, dayOffset), zipCode);
    }
}
