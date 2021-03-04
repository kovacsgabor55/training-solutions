package covid;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final int MEDICAL_RECORD_LENGTH = 9;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private final List<ZipCode> zipCodes;

    public Validator() {
        this.zipCodes = new ZipCodeDAO(new DatabaseConfig().getConfig()).getAllZipCodes();
    }

    public boolean isValidName(String fullName) {
        return (fullName != null) && !fullName.isEmpty() && !fullName.isBlank();
    }

    public boolean isValidMr(String medicalRecord) {
        Objects.requireNonNull(medicalRecord);
        if (medicalRecord.length() != MEDICAL_RECORD_LENGTH) {
            return false;
        }
        char[] medicalRecordChars = medicalRecord.substring(0, 8).toCharArray();
        int checkSum = 0;
        for (int i = 0; i < medicalRecordChars.length; i++) {
            if (i % 2 == 0) {
                checkSum += Character.getNumericValue(medicalRecordChars[i]) * 3;
            } else {
                checkSum += Character.getNumericValue(medicalRecordChars[i]) * 7;
            }
        }
        return checkSum % 10 == Integer.parseInt(medicalRecord.substring(8));
    }

    public boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public boolean isValidAge(int age) {
        return age > 10 && age < 150;
    }

    public boolean isValidZip(int zipCode) {
        return this.zipCodes.contains(new ZipCode(zipCode, null, null));
    }
}
