package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        System.out.println("Név?");
        client.name = scanner.nextLine();
        System.out.println("Év?");
        client.year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Cím?");
        client.address = scanner.nextLine();
        System.out.println("Név: " + client.name + " Év: " + client.year + " Cím: " + client.address);
    }

}
