package classsctructureintegrate;

import java.util.Scanner;

public class ProductProba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Név?");
        String name = scanner.nextLine();
        System.out.println("Ár?");
        int price = scanner.nextInt();
        scanner.nextLine();

        Product prod = new Product(name, price);
        System.out.println("Név: " + prod.getName() + ", Ár: " + prod.getPrice());

        System.out.println("Ár növelés:");
        prod.increasePrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Név: " + prod.getName() + ", Ár: " + prod.getPrice());

        System.out.println("Ár csökkentés:");
        prod.decreasePrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Név: " + prod.getName() + ", Ár: " + prod.getPrice());

    }
}
