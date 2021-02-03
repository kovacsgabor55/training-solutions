package week14d03;

import org.jetbrains.annotations.NotNull;

import java.util.*;

//1340-1404-1421
public class Student implements Comparable<Student> {
    private final String name;
    private final Map<String, List<Integer>> notes;

    public Student(@NotNull String name) {
        this.name = name;
        notes = new HashMap<>();
    }

    public Student(Student s) {
        name = s.name;
        notes = new HashMap<>(s.notes);
    }

    public void addNote(@NotNull String subject, int note) {
        if (!notes.containsKey(subject)) {
            notes.put(subject, new ArrayList<>());
        }
        notes.get(subject).add(note);
    }

    public Map<String, List<Integer>> getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", notes=" + notes + '}';
    }
}
