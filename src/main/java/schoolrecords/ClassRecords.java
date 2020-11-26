package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        for (Student item : students) {
            if (item.getName().equals(student.getName())) {
                return false;
            }
        }
        return students.add(student);
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double sum = 0.0;
        for (Student item : students) {
            sum += item.calculateAverage();
        }
        if (sum == 0.0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round((sum / students.size()) * 100.0) / 100.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        double sum = 0.0;
        int count = 0;
        for (Student item : students) {
            if (item.calculateSubjectAverage(subject) != 0.0) {
                sum += item.calculateSubjectAverage(subject);
                count++;
            }
        }
        return Math.round((sum / count) * 100.0) / 100.0;
    }

    public ClassRecords(String className, Random rnd) {
        if (isEmpty(className)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.className = className;
        this.rnd = rnd;
    }

    public Student findStudentByName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        for (Student item : students) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    public String getClassName() {
        return className;
    }

    private boolean isEmpty(String string) {
        return (string.equals("") || string.equals(null));
    }

    public String listStudentNames() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            stringBuilder.append(students.get(i).getName());
            if (i + 1 < students.size()) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResults = new ArrayList<>();
        for (Student item : students) {
            studyResults.add(new StudyResultByName(item.getName(), item.calculateAverage()));
        }
        return studyResults;
    }

    public boolean removeStudent(Student student) {
        for (Student item : students) {
            if (item.getName().equals(student.getName())) {
                return students.remove(item);
            }
        }
        return false;
    }

    public Student repetition() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));
    }
}
