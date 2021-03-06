package covid;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
    private static final int EXIT_SUCCESS = 0;  // Success
    private static final int EXIT_FAILURE = 0;  // Exception
    private static final int EXIT_ERROR = -1;   // Error
    private static final String MENU = "1. Registration\n2. Mass registration\n3. Generate\n4. Vaccination\n5. Vaccination failure\n6. Report\n7. Exit\nEnter your choice: ";
    private static final String VACCINES = "1. AstraZeneca\n2. CureVac\n3. Janssen\n4. Moderna\n5. Pfizer-BioNtech\n6. Sinopharm\n7. Szputynik\nEnter your choice: ";
    private static final Scanner scanner = new Scanner(System.in);
    private Validator validator;
    private CitizenDAO citizenDAO;
    private ZipCodeDAO zipCodeDAO;
    private FileManager fileManager;

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
                case '6' -> main.report();
                case '7' -> System.exit(EXIT_SUCCESS);
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
            List<Citizen> citizens = fileManager.loadCitizenToFile(reader);
            citizenDAO.insertCitizens(citizens);
        } catch (IOException e) {
            System.err.println("Invalid filename!");
            System.exit(EXIT_FAILURE);
        } catch (Exception e) {
            System.err.println("Invalid file!");
            e.printStackTrace();
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
        List<Citizen> input = citizenDAO.getAmountCitizenByZipCode(zipCode, 16, 2, 15);
        fileManager.saveCitizenToFile(input, zipCode);
    }

    private void vaccination() {
        System.out.println("Medical Record:");
        String medicalRecord = scanner.nextLine();
        if (!validator.isValidMr(medicalRecord)) {
            System.err.println("Medical Record is invalid!");
            System.exit(EXIT_ERROR);
        }
        try {
            Citizen citizen = citizenDAO.getCitizenByMedicalRecord(medicalRecord, 2, 15);
            LocalDate date;
            VaccineType type;
            if (citizen.getNumberOfVaccination() == 0) {
                date = setDate();
                type = setVaccine();
            } else {
                System.out.println("Vaccination date: " + citizen.getLastVaccination().toString());
                type = citizenDAO.getVaccination(citizen.getId(), citizen.getLastVaccination());
                System.out.println("Vaccine type: " + type.getValue());
                date = setDate();
            }

            System.out.println("Notes:");
            String note = scanner.nextLine();
            citizenDAO.writeVaccination(medicalRecord, date, VaccinationStatus.SUCCESS, note, type);
        } catch (IllegalArgumentException e) {
            System.err.println("Nem létező személy vagy már megvolt a második oltása");
        }
    }

    private void vaccinationFailure() {
        System.out.println("Medical Record:");
        String medicalRecord = scanner.nextLine();
        if (!validator.isValidMr(medicalRecord)) {
            System.err.println("Medical Record is invalid!");
            System.exit(EXIT_ERROR);
        }
        LocalDate date = setDate();
        System.out.println("causes of failure notes:");
        String note = scanner.nextLine();
        citizenDAO.writeVaccination(medicalRecord, date, VaccinationStatus.FAILURE, note, VaccineType.NONE);
    }

    private void report() {
        System.out.println("Zip Code:");
        int zipCode = scanner.nextInt();
        scanner.nextLine();
        if (!validator.isValidZip(zipCode)) {
            System.err.println("Invalid ZIP code!");
            System.exit(EXIT_ERROR);
        }
        System.out.println(zipCodeDAO.getCity(zipCode));
        System.out.println(citizenDAO.report(zipCode));
    }

    private void init() {
        DataSource config = new DatabaseConfig().getConfig();

        //Flyway flyway = Flyway.configure().dataSource(config).load();
        // flyway.clean();
        // flyway.migrate();

        citizenDAO = new CitizenDAO(config);
        zipCodeDAO = new ZipCodeDAO(config);
        fileManager = new FileManager();
        validator = new Validator();
    }

    private LocalDate setDate() {
        System.out.println("Date: 1. now 2. other");
        String choose = scanner.nextLine();
        if (choose.equals("1")) {
            return LocalDate.now();
        } else {
            System.out.println("Vaccination date (yyyy-mm-dd) :");
            String datetxt = scanner.nextLine();
            return LocalDate.parse(datetxt);
        }
    }

    private VaccineType setVaccine() {
        char command;
        System.out.print(VACCINES);
        command = scanner.nextLine().charAt(0);
        switch (command) {
            case '1':
                return VaccineType.ASTRAZENECA;
            case '2':
                return VaccineType.CUREVAC;
            case '3':
                return VaccineType.JANSSEN;
            case '4':
                return VaccineType.MODERNA;
            case '5':
                return VaccineType.PFIZER_BIONTECH;
            case '6':
                return VaccineType.SINOPHARM;
            case '7':
                return VaccineType.SPUTNIKV;
            default:
                System.err.print("wrong choice!!!");
        }
        throw new IllegalStateException("wrong choice!");
    }
}
