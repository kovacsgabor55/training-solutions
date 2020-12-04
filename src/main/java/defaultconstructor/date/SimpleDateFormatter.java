package defaultconstructor.date;

public class SimpleDateFormatter {

    public String formatDateString(SimpleDate simpleDate) {
        return formatDateStringByCountryCode(CountryCode.HU, simpleDate);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        if (countryCode.EN == countryCode) {
            return simpleDate.getDay() + "-" + simpleDate.getMonth() + "-" + simpleDate.getYear();
        } else if (CountryCode.US == countryCode) {
            return simpleDate.getMonth() + "-" + simpleDate.getDay() + "-" + simpleDate.getYear();
        } else {
            return simpleDate.getYear() + "-" + simpleDate.getMonth() + "-" + simpleDate.getDay();
        }
    }
}
