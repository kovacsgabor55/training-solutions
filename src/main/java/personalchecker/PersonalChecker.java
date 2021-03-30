package personalchecker;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

//https://hu.wikipedia.org/wiki/Szem%C3%A9lyi_azonos%C3%ADt%C3%B3
//https://hu.wikipedia.org/wiki/ISBN
//https://regi.tankonyvtar.hu/hu/tartalom/tamop425/0038_informatika_Geda_Gabor_Hernyak_Zoltan-Algoritmizalas_es_adatmodellek/ch07s02.html
public class PersonalChecker {
    private static final int SSNLENGHT = 9;
    private static final int TAXDIVISOR = 11;
    private static final int TAXLENGHT = 10;
    private static final int TAXDIVIDEVALIDATOR = 10;
    private static final LocalDate TAXSTARTDATE = LocalDate.of(1867, 1, 1);

    private PersonalChecker() {
    }

    /**
     * Tax number checker https://muzso.hu/2011/10/26/adoazonosito-jel-ellenorzo-osszeg-generator
     * https://hu.wikipedia.org/wiki/Ad%C3%B3sz%C3%A1m#Ellen%C5%91rz%C5%91_sz%C3%A1m_sz%C3%A1m%C3%ADt%C3%A1sa
     * https://hu.wikipedia.org/wiki/Ad%C3%B3azonos%C3%ADt%C3%B3_jel
     *
     * @param taxNumber
     * @param birthDate
     * @return
     */
    public static boolean isValidTaxNumber(String taxNumber, LocalDate birthDate) {
        Objects.requireNonNull(taxNumber);
        Objects.requireNonNull(birthDate);
        if (taxNumber.length() != TAXLENGHT) {
            return false;
        }
        if (!taxNumber.substring(0, 1).equals("8")) {
            return false;
        }
        if (ChronoUnit.DAYS.between(TAXSTARTDATE, birthDate) != Long.parseLong(taxNumber.substring(1, 6))) {
            return false;
        }
        char[] taxChars = taxNumber.substring(0, 9).toCharArray();
        int checkSum = 0;
        for (int i = 0; i < taxChars.length; i++) {
            checkSum += Character.getNumericValue(taxChars[i]) * (i + 1);
        }
        if (checkSum % TAXDIVISOR == TAXDIVIDEVALIDATOR) {
            return false;
        }//CDV kód
        return checkSum % TAXDIVISOR == Long.parseLong(taxNumber.substring(9));
    }

    /**
     * Taj szám checker
     *
     * @param ssn
     * @return
     */
    public static boolean isValidSsn(String ssn) {
        Objects.requireNonNull(ssn);
        if (ssn.length() != SSNLENGHT) {
            return false;
        }
        char[] ssnChars = ssn.substring(0, 8).toCharArray();
        int checkSum = 0;
        for (int i = 0; i < ssnChars.length; i++) {
            if (i % 2 == 0) {
                checkSum += Character.getNumericValue(ssnChars[i]) * 3;
            } else {
                checkSum += Character.getNumericValue(ssnChars[i]) * 7;
            }
        }
        return checkSum % 10 == Integer.parseInt(ssn.substring(8));
    }
}
