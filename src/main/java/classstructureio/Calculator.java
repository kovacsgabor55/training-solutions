package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int szam1 = scanner.nextInt();
        scanner.nextLine();
        int szam2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println(szam1 + " + " + szam2);
        System.out.println(szam1 + szam2);
    }
}
