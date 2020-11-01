package classsctructureintegrate;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount acc1 = new BankAccount("10073217-12000098-67341590", "Tóth Kálmán", 103400);
        BankAccount acc2 = new BankAccount("10073217-12000098-67341592", "Tóth Béla", 652142);

        System.out.println(acc1.getInfo());
        System.out.println(acc2.getInfo());

        System.out.println("Pénzfelvét Kálmán 2514 és Béla  4172");
        acc1.withdraw(2514);
        acc2.withdraw(4172);

        System.out.println(acc1.getInfo());
        System.out.println(acc2.getInfo());

        System.out.println("Befizetés Kálmán 1241 és Béla  2164");
        acc1.withdraw(1241);
        acc2.withdraw(2164);

        System.out.println(acc1.getInfo());
        System.out.println(acc2.getInfo());

        System.out.println("Átutalás Kálmán to Béla  1425");

        BankAccount.transfer(acc1, acc2, 1425);

        System.out.println(acc1.getInfo());
        System.out.println(acc2.getInfo());

    }
}
