package classsctructureconstructors;

import java.util.Scanner;

public class StoreMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store st1 = new Store("prod1");
        Store st2 = new Store("prod2");

        System.out.println("első raktárhoz hozzáadás:");
        st1.store(scanner.nextInt());
        scanner.nextLine();

        System.out.println("második raktárhoz hozzáadás:");
        st2.store(scanner.nextInt());
        scanner.nextLine();

        System.out.println(st1.toString());
        System.out.println(st2.toString());

        System.out.println("első raktárból elvétel:");
        st1.dispatch(scanner.nextInt());
        scanner.nextLine();

        System.out.println("második raktárból elvétel:");
        st2.dispatch(scanner.nextInt());
        scanner.nextLine();

        System.out.println(st1.toString());
        System.out.println(st2.toString());
    }
}
