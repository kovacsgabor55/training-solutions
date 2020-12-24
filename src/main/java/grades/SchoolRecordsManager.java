package grades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {
    private List<Student> students;

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public SchoolRecordsManager() {
        students = new ArrayList<>();
    }

    public void readGradesFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + filename))) {
            String str;
            while ((str = br.readLine()) != null) {
                String[] stud = str.split(" ");
                List<Integer> grades = new ArrayList<>();
                for (int i = 1; i < stud.length; i++) {
                    grades.add(Integer.parseInt(stud[i]));
                }
                students.add(new Student(stud[0], grades));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public double classAverage() {
        double suma = 0;
        for (Student item : students) {
            suma += item.average();
        }
        return suma / students.size();
    }
}
