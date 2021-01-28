package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public String merge(Path file, List<Employee> employees) {
        return parse(loadTemplate(file), employees);
    }

    private String parse(String template, List<Employee> employees) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee item : employees) {
            stringBuilder.append(template.replace("{nev}", item.getName()).replace("{ev}", Integer.toString(item.getYearOfBirth())));
        }
        return stringBuilder.toString();
    }

    private String loadTemplate(Path file) {
        try {
            return Files.readString(file);
        } catch (IOException e) {
            throw new IllegalArgumentException("something happened!", e);
        }
    }

    public static void main(String[] args) {
        List<Employee> emp = List.of(new Employee("John Doe", 1980), new Employee("Jack Doe", 1990));
        System.out.println(new TemplateMerger().merge(Path.of("src/main/resources/template.txt"), emp));
    }
}
