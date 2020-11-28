package introexception.patient;

public class SsnValidator {
    public boolean isValidSsn(String ssn) {
        int sum = 0;
        char[] ssnc = ssn.toCharArray();
        if (ssn.length() == 9) {
            for (int i = 1; i <= 8; i++) {
                if (i % 2 != 0) {
                    sum += Character.getNumericValue(ssnc[i - 1]) * 3;
                } else {
                    sum += Character.getNumericValue(ssnc[i - 1]) * 7;
                }
            }
        } else {
            return false;
        }
        return (sum % 10 == Character.getNumericValue(ssnc[ssnc.length - 1]));
    }
}
