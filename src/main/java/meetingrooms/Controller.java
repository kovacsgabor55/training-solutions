package meetingrooms;

import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    Office office;

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
    }

    void readOffice() {
        office = new Office();
        System.out.println("Hány Meeting roomot kérjük be?");
        int roomsNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= roomsNumber; i++) {
            System.out.println("Kérem a(z) " + i + ". szoba nevét:");
            String name = scanner.nextLine();
            System.out.println("Kérem a(z) " + i + ". szoba husszúságát:");
            int length = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Kérem a(z) " + i + ". szoba szélességét:");
            int width = scanner.nextInt();
            scanner.nextLine();
            office.addMeetingRoom(new MeetingRoom(name, length, width));
        }
    }

    void printMenu() {
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
    }

    void runMenu() {
        int menuNumber = scanner.nextInt();
        scanner.nextLine();
        switch (menuNumber) {
            case 1:
                office.printNames();
                break;
            case 2:
                office.printNamesReserve();
                break;
            case 3:
                office.printEventNames();
                break;
            case 4:
                office.printAreas();
                break;
            case 5:
                System.out.println("Kérem a nevet:");
                String roomName = scanner.nextLine();
                office.printMeetingRoomsWithNames(roomName);
                break;
            case 6:
                System.out.println("Kérem a rész nevet:");
                String roomPartName = scanner.nextLine();
                office.printMeetingRoomsContains(roomPartName);
                break;
            case 7:
                System.out.println("Kérem a területet:");
                int area = scanner.nextInt();
                scanner.nextLine();
                office.printAreasLargerThan(area);
                break;
        }
    }
}
