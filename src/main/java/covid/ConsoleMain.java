package covid;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
    private static final int EXIT_SUCCESS = 0;  // Success
    private static final int EXIT_FAILURE = 0;  // Exception
    private static final int EXIT_ERROR = -1;   // Error
    private static final String MENU = "1. Registration\n2. Mass registration\n3. Generate\n4. Vaccination\n5. Vaccination failure\n6. Exit\nEnter your choice: ";
    private static final Scanner scanner = new Scanner(System.in);
    private Validator validator;
    private CitizenDAO citizenDAO;
    private ZipCodeDAO zipCodeDAO;

    public static void main(String[] args) {
        ConsoleMain main = new ConsoleMain();
        main.init();

        char command;
        do {
            System.out.print(MENU);
            command = scanner.nextLine().charAt(0);
            switch (command) {
                case '1' -> main.registration();
                case '2' -> main.massRegistration();
                case '3' -> main.generation();
                case '4' -> main.vaccination();
                case '5' -> main.vaccinationFailure();
                case '6' -> System.exit(EXIT_SUCCESS);
                default -> System.err.print("wrong choice!!!");
            }
        } while (command != 6);
    }

    private void registration() {
        System.out.println("Full name:");
        String name = scanner.nextLine();
        if (!validator.isValidName(name)) {
            System.err.println("Name cannot be empty or blank!");
            System.exit(EXIT_ERROR);
        }
        System.out.println("Zip Code:");
        int zipCode = scanner.nextInt();
        scanner.nextLine();
        if (!validator.isValidZip(zipCode)) {
            System.err.println("Invalid ZIP code!");
            System.exit(EXIT_ERROR);
        }
        System.out.println(zipCodeDAO.getCity(zipCode));
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
        System.out.println("Medical Record:");
        String medicalRecord = scanner.nextLine();
        if (!validator.isValidMr(medicalRecord)) {
            System.err.println("Medical Record is invalid!");
            System.exit(EXIT_ERROR);
        }
        citizenDAO.insertCitizen(new Citizen(name, zipCode, age, email, medicalRecord));
    }

    private void massRegistration() {
        System.out.println("Please enter your registration filename:");
        String fileName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ConsoleMain.class.getResourceAsStream(fileName)))) {
            List<Citizen> citizens = citizenDAO.loadCitizenToFile(reader);
            citizenDAO.insertCitizens(citizens);
        } catch (IOException e) {
            System.err.println("Invalid filename!");
            System.exit(EXIT_FAILURE);
        } catch (Exception e) {
            System.err.println("Invalid file!");
            System.exit(EXIT_FAILURE);
        }
    }

    private void generation() {
        System.out.println("Zip Code:");
        int zipCode = scanner.nextInt();
        scanner.nextLine();
        if (!validator.isValidZip(zipCode)) {
            System.err.println("Invalid ZIP code!");
            System.exit(EXIT_ERROR);
        }
        System.out.println("File name:");
        String fileName = scanner.nextLine();
        citizenDAO.saveCitizenToFile(zipCode, fileName);
    }

    private void vaccination() {
        System.out.println("Medical Record:");
        String medicalRecord = scanner.nextLine();
        if (!validator.isValidMr(medicalRecord)) {
            System.err.println("Medical Record is invalid!");
            System.exit(EXIT_ERROR);
        }

        System.out.println("Vaccination date (yyyy-mm-dd hh:mm) :");
        String date = scanner.nextLine();

    }

    private void vaccinationFailure() {
        System.out.println("Medical Record:");
        String medicalRecord = scanner.nextLine();
        if (!validator.isValidMr(medicalRecord)) {
            System.err.println("Medical Record is invalid!");
            System.exit(EXIT_ERROR);
        }

        System.out.println("Note:");
        String note = scanner.nextLine();
    }

    private void init() {
        DataSource config = new DatabaseConfig().getConfig();

        //Flyway flyway = Flyway.configure().dataSource(config).load();
       // flyway.clean();
       // flyway.migrate();

        citizenDAO = new CitizenDAO(config);
        zipCodeDAO = new ZipCodeDAO(config);
        validator = new Validator();
    }
}
