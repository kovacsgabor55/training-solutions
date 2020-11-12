package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("név");
        String name = scanner.nextLine();
        System.out.println("év");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("hó");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("nap");
        int day = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(year, month, day, name);
        System.out.println("Név: " + employee.getName() + " Szül: " + employee.getDateOfBirth() + " Beiratkozás: " + employee.getBeginEmployment());
    }
}
