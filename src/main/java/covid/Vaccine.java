package covid;

public enum Vaccine {

    NONE("None"), ASTRAZENECA("AstraZeneca"), PFIZER_BIONTECH("Pfizer-BioNtech"), MODERNA("Moderna"), JANSSEN("Janssen"), CUREVAC("CureVac"), SPUTNIKV("Szputynik"), SINOPHARM("Sinopharm");
    private final String value;

    Vaccine(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
