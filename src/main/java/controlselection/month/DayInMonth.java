package controlselection.month;

public class DayInMonth {
    int numberOfDays(int year, String month) {
        switch (month.toLowerCase()) {
            case "Január":
            case "március":
            case "május":
            case "július":
            case "augusztus":
            case "október":
            case "december":
                return 31;
            case "április":
            case "június":
            case "szeptember":
            case "november":
                return 30;
            case "február":
                return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }
}
