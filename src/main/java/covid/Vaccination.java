package covid;

import java.time.LocalDate;

public class Vaccination {
    private int vaccination_id;
    private int citizen_id;
    private LocalDate vaccination_date;
    private VaccinationStatus status;
    private String note;
    private Vaccine vaccination_type;

    public Vaccination(int vaccination_id, int citizen_id, LocalDate vaccination_date, VaccinationStatus status, String note, Vaccine vaccination_type) {
        this.vaccination_id = vaccination_id;
        this.citizen_id = citizen_id;
        this.vaccination_date = vaccination_date;
        this.status = status;
        this.note = note;
        this.vaccination_type = vaccination_type;
    }

    public int getVaccination_id() {
        return vaccination_id;
    }

    public int getCitizen_id() {
        return citizen_id;
    }

    public LocalDate getVaccination_date() {
        return vaccination_date;
    }

    public VaccinationStatus getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public Vaccine getVaccination_type() {
        return vaccination_type;
    }
}
