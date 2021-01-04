package week04d03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int ra = random.nextInt(99) + 1;
        for (int i = 1; i <= 6; i++) {
            System.out.println("Kérek egy számot Probálkozás: " + i);
            int val = scanner.nextInt();
            if (ra == val) {
                System.out.println("eltaláltad.");
                System.exit(0);
            } else if (ra < val) {
                System.out.println("kisebb.");
            } else {
                System.out.println("nagyobb.");
            }
        }
        System.out.println("Nem találtad el :(");
    }
}
