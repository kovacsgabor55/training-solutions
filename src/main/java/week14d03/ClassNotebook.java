package week14d03;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassNotebook {
    private final List<Student> students = new ArrayList<>();

    public List<Student> sortNotebook() {
        List<Student> result = new ArrayList<>(students);
        Collections.sort(result);
        return result;
    }

    public void addStudent(@NotNull String name) {
        students.add(new Student(name));
    }

    public void gradeNote(@NotNull String name, @NotNull String subject, @NotNull int note) {
        Student query = new Student(name);
        if (students.contains(query)) {
            int index = students.indexOf(query);
            students.get(index).putNote(subject, note);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public static void main(String[] args) {
        ClassNotebook cln = new ClassNotebook();
        cln.addStudent("Kristóf");
        cln.addStudent("Arnold");
        cln.addStudent("István");
        System.out.println(cln.getStudents().size());
        cln.gradeNote("Arnold", "Biológia", 3);
        cln.gradeNote("Kristóf", "Matematika", 5);
        cln.gradeNote("Kristóf", "Matematika", 4);
        cln.gradeNote("Kristóf", "Biológia", 2);
        cln.gradeNote("István", "Kémia", 4);
        System.out.println(cln.sortNotebook());
    }
}
