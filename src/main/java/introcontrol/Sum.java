package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        System.out.println("Írj be 5 számot enterrel elválasztva:");
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Összeg: " + sum);
    }
}
