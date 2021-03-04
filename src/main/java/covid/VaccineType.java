package covid;

public enum VaccineType {

    NONE("None"), ASTRAZENECA("AstraZeneca"), PFIZER_BIONTECH("Pfizer-BioNtech"), MODERNA("Moderna"), JANSSEN("Janssen"), CUREVAC("CureVac"), SPUTNIKV("Szputynik"), SINOPHARM("Sinopharm");
    private final String value;

    VaccineType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
