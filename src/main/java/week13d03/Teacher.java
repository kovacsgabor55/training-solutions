package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Teacher {
    public int getTeachingTime(String teacherName) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("beosztas.txt"))) {
            String line;
            int hour = 0;
            while ((line = br.readLine()) != null) {
                if (line.equals(teacherName)) {
                    br.readLine();
                    br.readLine();
                    hour += Integer.parseInt(br.readLine());
                } else {
                    br.readLine();
                    br.readLine();
                    br.readLine();
                }
            }
            return hour;
        } catch (IOException e) {
            throw new IllegalArgumentException(teacherName + " cant find", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Teacher().getTeachingTime("Cet Celina"));
    }
}
