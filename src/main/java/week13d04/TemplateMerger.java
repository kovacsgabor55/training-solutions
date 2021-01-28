package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {
    private String sablon;

    public String merge(Path file, List<Employee> employees) {
        try {
            sablon = Files.readString(file);
            return parse(sablon, employees);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("something happened!");
        }
    }

    private String parse(String sablon, List<Employee> employees) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee item : employees) {
            stringBuilder.append(sablon.replace("{nev}", item.getName()).replace("{ev}", Integer.toString(item.getYearOfBirth())) + "\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        List<Employee> emp = List.of(new Employee("John Doe", 1980), new Employee("Jack Doe", 1990));
        System.out.println(new TemplateMerger().merge(Path.of("template.txt"), emp));
    }
}
