package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Név?");
        String name = scanner.nextLine();
        System.out.println("E-mail?");
        String email = scanner.nextLine();
        System.out.println("Név: " + name + " E-mail: " + email);
    }
}
