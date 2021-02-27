package covid;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleMain {
    private static final int EXIT_SUCCESS = 0;  //Success
    private static final int EXIT_FAILURE = 1;  // Exception
    private static final int EXIT_ERROR = -1;   // Error
    private static final String MENU = "1. Registration\n2. Tömeges registration\n3. Generating\n4. Vaccination\n5. Vaccination failure\n6. Exit\nEnter your choice: ";
    private static final Scanner scanner = new Scanner(System.in);
    private static Validator validator;
    private MariaDbDataSource dataSource;
    private CitizenDAO citizenDAO;

    public static void main(String[] args) {
        ConsoleMain main = new ConsoleMain();
        main.init();

        char command;
        do {
            System.out.print(MENU);
            command = scanner.nextLine().charAt(0);
            switch (command) {
                case '1' -> main.reg();
                case '2' -> main.treg();
                case '3' -> main.gen();
                case '4' -> main.olt();
                case '5' -> main.oltfail();
                case '6' -> System.exit(EXIT_SUCCESS);
                default -> System.err.print("wrong choice!!!");
            }
        } while (command != 6);
    }

    private void reg() {
        System.out.println("Full name:");
        String name = scanner.nextLine();
        if (!validator.isValidName(name)) {
            System.err.println("Name cannot be empty or blank!");
            System.exit(EXIT_ERROR);
        }
        System.out.println("Zip Code:");
        int zip = scanner.nextInt();
        scanner.nextLine();
        if (!validator.isValidZip(zip, citizenDAO.findZip())) {
            System.err.println("Invalid ZIP code!");
            System.exit(EXIT_ERROR);
        }
        System.out.println("Age:");
        int age = scanner.nextInt();
        if (!validator.isValidAge(age)) {
            System.err.println("Age must between 10 or 150!");
            System.exit(EXIT_ERROR);
        }
        scanner.nextLine();
        System.out.println("E-mail:");
        String email = scanner.nextLine();
        if (!validator.isValidEmail(email)) {
            System.err.println("E-mail most RFC822 pattern!");
            System.exit(EXIT_ERROR);
        }
        System.out.println("Re type e-mail:");
        if (!email.equals(scanner.nextLine())) {
            System.err.println("Re type e-mail not equals email!");
            System.exit(EXIT_ERROR);
        }
        System.out.println("TAJ szám");
        String taj = scanner.nextLine();
        if (!validator.isValidMr(taj)) {
            System.err.println("Medical Record is invalid!");
            System.exit(EXIT_ERROR);
        }
    }

    private void treg() {

    }

    private void gen() {

    }

    private void olt() {

    }

    private void oltfail() {

    }

    private void init() {
        dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/vaccination_register?useUnicode=true");
            dataSource.setUser("vaccination_register");
            dataSource.setPassword("vaccination_register");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        citizenDAO = new CitizenDAO(dataSource);
        validator = new Validator();
    }

    public static Validator getValidator() {
        return validator;
    }
}
