package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Mark> marks = new ArrayList<>();
    private String name;

    public double calculateAverage() {
        if (marks.size() == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (Mark item : marks) {
            sum += item.getMarkType().getValue();
        }
        return Math.round((sum / marks.size()) * 100.0) / 100.0;
    }

    public double calculateSubjectAverage(Subject subject) {
        double sum = 0.0;
        int count = 0;
        for (Mark item : marks) {
            if (item.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sum += item.getMarkType().getValue();
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return Math.round((sum / count) * 100.0) / 100.0;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    private boolean isEmpty(String string) {
        return (string.equals("") || string.equals(null)) ? true : false;
    }

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        } else {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + " marks:");
        for (Mark item : marks) {
            stringBuilder.append(" " + item.getSubject().getSubjectName() + ": " + item);
        }
        return stringBuilder.toString();
    }
}
