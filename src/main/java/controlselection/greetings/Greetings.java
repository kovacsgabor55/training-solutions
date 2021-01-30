package controlselection.greetings;

public class Greetings {

    public String greet(int hour, int minute) {

        if (hour < 5) {
            return "jó éjt";
        } else if (hour < 9) {
            return "jó éjt";
        } else if (hour <= 17 || (hour == 18 && minute <= 30)) {
            return "1";
        } else if (hour < 20) {
            return "5";
        } else {
            return "6";
        }

    }
}
