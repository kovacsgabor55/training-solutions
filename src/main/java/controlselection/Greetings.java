package controlselection;

public class Greetings {

    public String sayGreeting(int hour, int minute) {

        if (hour < 5) {
            return "Good Night!";
        } else if (hour < 9) {
            return "Good Morning!";
        } else if (hour <= 17 || (hour == 18 && minute <= 30)) {
            return "Good Afternoon!";
        } else if (hour < 20) {
            return "Good Evening!";
        } else {
            return "Good Night!";
        }

    }
}
