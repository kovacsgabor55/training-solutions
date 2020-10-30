package classsctructureconstructors;

import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Szerző?");
        String aut = scanner.nextLine();
        System.out.println("Címe?");
        String tit = scanner.nextLine();

        Book book = new Book(aut, tit);
        System.out.println("Regisztrációs szám?");
        String reg = scanner.nextLine();
        book.register(reg);
        System.out.println("Szerző: " + book.getAuthor() + " Cím: " + book.getTitle() + " Registnum: " + book.getRegNumber());
    }
}
