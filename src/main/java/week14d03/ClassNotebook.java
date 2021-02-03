package week14d03;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassNotebook {
    private final List<Student> students;

    public ClassNotebook(List<Student> students) {
        this.students = students;
    }

    public List<Student> sortNotebook() {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            result.add(new Student(s));
        }
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
            students.get(index).addNote(subject, note);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
