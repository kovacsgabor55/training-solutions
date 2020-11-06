package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérek egy egész számot");
        int number = sc.nextInt();
        sc.nextLine();

        if (number % 3 == 0) {
            System.out.println("A szám " + number + " osztható 3-mal");
        } else {
            System.out.println("A szám " + number + " nem osztható 3-mal");
        }
    }
}
