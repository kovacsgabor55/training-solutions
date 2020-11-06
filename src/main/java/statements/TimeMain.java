package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Time[] times = new Time[2];

        for (int i = 1; i <= 2; i++) {
            System.out.println("Kérem a(z) " + i + ". időpont óra adatát");
            int hour = sc.nextInt();
            sc.nextLine();
            System.out.println("Kérem a(z) " + i + ". időpont perc adatát");
            int minute = sc.nextInt();
            sc.nextLine();
            System.out.println("Kérem a(z) " + i + ". időpont másodperc adatát");
            int second = sc.nextInt();
            sc.nextLine();
            times[i - 1] = new Time(hour, minute, second);
        }
        System.out.println("Az első időpont " + times[0].toString() + " = " + times[0].getInMinutes() + " perc");
        System.out.println("A második időpont " + times[1].toString() + " = " + times[1].getInSeconds() + " másodperc");
        System.out.println("Az első korábbi, mint a második: " + times[0].earlierThan(times[1]));
    }
}
