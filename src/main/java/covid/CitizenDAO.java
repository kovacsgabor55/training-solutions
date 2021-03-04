package covid;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAO {
    private final DataSource dataSource;

    public CitizenDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Citizen insertCitizen(Citizen citizen) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO `citizens`(`citizen_name`, `zip_code`, `age`, `email`, `medical_record`) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, citizen.getFullName());
            stmt.setInt(2, citizen.getZipCode());
            stmt.setInt(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getMedicalRecord());
            stmt.executeUpdate();
            int id = executeAndGetGeneratedKey(stmt);
            return new Citizen(id, citizen.getFullName(), citizen.getZipCode(), citizen.getAge(), citizen.getEmail(), citizen.getMedicalRecord());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cannot insert", e);
        }
    }

    private int executeAndGetGeneratedKey(PreparedStatement stmt) {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            throw new SQLException("No key was generated.");
        } catch (SQLException e) {
            throw new IllegalArgumentException("Insertion failed.", e);
        }
    }

    private List<Integer> executeAndGetGeneratedKeys(PreparedStatement stmt) {
        List<Integer> result = new ArrayList<>();
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            while (rs.next()) {
                result.add(rs.getInt(1));
            }
            if (result.isEmpty()) {
                throw new SQLException("No key was generated.");
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException("Insertion failed.", e);
        }
    }

    public List<Citizen> insertCitizens(List<Citizen> citizens) {
        if (citizens.isEmpty()) {
            throw new IllegalArgumentException("Citizens list cannot be empty");
        }
        try (Connection conn = dataSource.getConnection()) {
            return insertCitizensTransaction(conn, citizens);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect", e);
        }
    }

    private List<Citizen> insertCitizensTransaction(Connection conn, List<Citizen> citizens) throws SQLException {
        String sql = "INSERT INTO `citizens`(`citizen_name`, `zip_code`, `age`, `email`, `medical_record`) VALUES" + "(?,?,?,?,?),".repeat(citizens.size());
        sql = sql.substring(0, sql.length() - 1);
        List<Citizen> result = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            conn.setAutoCommit(false);
            int count = 0;
            for (Citizen item : citizens) {
                stmt.setString(1 + count, item.getFullName());
                stmt.setInt(2 + count, item.getZipCode());
                stmt.setInt(3 + count, item.getAge());
                stmt.setString(4 + count, item.getEmail());
                stmt.setString(5 + count, item.getMedicalRecord());
                count += 5;
            }
            stmt.executeUpdate();
            List<Integer> id = executeAndGetGeneratedKeys(stmt);
            for (int i = 0; i < citizens.size(); i++) {
                result.add(new Citizen(id.get(i), citizens.get(i).getFullName(), citizens.get(i).getZipCode(), citizens.get(i).getAge(), citizens.get(i).getEmail(), citizens.get(i).getMedicalRecord()));
            }
            conn.commit();
            return result;
        } catch (Exception sqlException) {
            conn.rollback();
            throw new IllegalArgumentException("Cannot insert", sqlException);
        }
    }

    public List<Citizen> getAmountCitizenByZipCode(int zipCode, int amount, int maxVaccination, int dayOffset) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `citizens` WHERE `zip_code` = ? AND `number_of_vaccination` < ? AND (`last_vaccination` is NULL OR DATE_ADD(`last_vaccination`, INTERVAL ? DAY) < CURRENT_DATE()) ORDER BY `age` DESC, `citizen_name` ASC LIMIT ?")) {
            stmt.setInt(1, zipCode);
            stmt.setInt(2, maxVaccination);
            stmt.setInt(3, dayOffset);
            stmt.setInt(4, amount);
            return selectCitizensPreparedStatement(stmt);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }
    }

    private List<Citizen> selectCitizensPreparedStatement(PreparedStatement stmt) {
        List<Citizen> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("citizen_id");
                String name = rs.getString("citizen_name");
                int zip = rs.getInt("zip_code");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String mr = rs.getString("medical_record");
                int nrofvac = rs.getInt("number_of_vaccination");
                LocalDate lasvac = rs.getDate("last_vaccination").toLocalDate();
                result.add(new Citizen(id, name, zip, age, email, mr, nrofvac, lasvac));
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException("Execute failed!", e);
        }
    }

    //TODO atirni taj alapjan visszaad cicizent
    public Citizen getCitizenByMedicalRecord(String medicalRecord, int maxVaccination, int dayOffset) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `citizens` WHERE `medical_record` = ? AND `number_of_vaccination` < ? AND (`last_vaccination` is NULL OR DATE_ADD(`last_vaccination`, INTERVAL ? DAY) < CURRENT_DATE())")) {
            stmt.setString(1, medicalRecord);
            stmt.setInt(2, maxVaccination);
            stmt.setInt(3, dayOffset);
            List<Citizen> citizens = selectCitizensPreparedStatement(stmt);
            if (!citizens.isEmpty()) {
                return citizens.get(0);
            }
            throw new IllegalArgumentException("Cannot select citizen");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }
    }

    public void writeVaccination(String medicalRecord, LocalDate date, VaccinationStatus status, String note, Vaccine type) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `citizens` WHERE `medical_record` = ?")) {
            stmt.setString(1, medicalRecord);
            List<Citizen> citizens = selectCitizensPreparedStatement(stmt);
            if (!citizens.isEmpty()) {
                conn.setAutoCommit(false);
                int citizenId = citizens.get(0).getId();
                int vacnr = citizens.get(0).getNumberOfVaccination() + 1;
                insertVaccination(conn, citizenId, date, status, note, type, vacnr);
                conn.commit();
            } else {
                conn.rollback();
                throw new IllegalArgumentException("Cannot select citizen");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }
    }

    private void insertVaccination(Connection conn, int citizenId, LocalDate date, VaccinationStatus status, String note, Vaccine type, int vacnr) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO `vaccinations` (`citizen_id`,`vaccination_date`,`status`,`note`,`vaccination_type`) VALUES (?,?,?,?,?)")) {
            stmt.setInt(1, citizenId);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setString(3, status.toString());
            stmt.setString(4, note);
            stmt.setString(5, type.toString());
            stmt.executeUpdate();
            if (type != Vaccine.NONE) {
                updateCitizenById(conn, citizenId, date, vacnr);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot Insert!", e);
        }
    }

    private void updateCitizenById(Connection conn, int citizenId, LocalDate date, int vacnr) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE `citizens` SET `number_of_vaccination` = ?, `last_vaccination` = ? WHERE `citizen_id` = ?")) {
            stmt.setInt(1, vacnr);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setInt(3, citizenId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot Insert!", e);
        }
    }

    public Vaccine getVaccination(int citizenId, LocalDate date) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `vaccinations` WHERE `citizen_id` = ? AND `vaccination_date` = ? ORDER BY `vaccination_id` ASC")) {
            stmt.setInt(1, citizenId);
            stmt.setDate(2, Date.valueOf(date));
            List<Vaccination> out = selectVaccinationsPreparedStatement(stmt);
            if (out.isEmpty()) {
                throw new IllegalStateException("No vaccination found");
            }
            for (int i = out.size() - 1; i >= 0; i--) {
                if (out.get(i).getVaccination_type() != Vaccine.NONE) {
                    return out.get(i).getVaccination_type();
                }
            }
            throw new IllegalArgumentException("Cannot select vaccinazitation");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect!", e);
        }
    }

    private List<Vaccination> selectVaccinationsPreparedStatement(PreparedStatement stmt) {
        List<Vaccination> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("vaccination_id");
                int citid = rs.getInt("citizen_id");
                LocalDate date = rs.getDate("vaccination_date").toLocalDate();
                VaccinationStatus status = VaccinationStatus.valueOf(rs.getString("status"));
                String note = rs.getString("note");
                Vaccine type = Vaccine.valueOf(rs.getString("vaccination_type"));
                result.add(new Vaccination(id, citid, date, status, note, type));
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException("Execute failed!", e);
        }
    }
}
