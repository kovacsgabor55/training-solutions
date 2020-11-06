package statements;

import java.util.Scanner;

public class InvestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Befektetés összege:");
        int found = sc.nextInt();
        sc.nextLine();
        System.out.println("Kamatláb:");
        int interestRate = sc.nextInt();
        sc.nextLine();
        Investment investment = new Investment(found, interestRate);
        System.out.println("Tőke: " + investment.getFund());
        System.out.println("Hozam 50 napra: " + investment.getYield(50));
        System.out.println("Kivett összeg 80 nap után: " + investment.close(80));
        System.out.println("Kivett összeg 90 nap után: " + investment.close(90));
    }
}
