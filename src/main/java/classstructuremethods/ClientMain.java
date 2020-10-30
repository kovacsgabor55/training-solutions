package classstructuremethods;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        System.out.println("Név?");
        client.setName(scanner.nextLine());
        System.out.println("Év?");
        client.setYear(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Cím?");
        client.setAddress(scanner.nextLine());
        System.out.println("Név: " + client.getName() + " Év: " + client.getYear() + " Cím: " + client.getAddress());

        System.out.println("Új cím?");
        client.migrate(scanner.nextLine());
        System.out.println("Új cím: " + client.getName());
    }
}
