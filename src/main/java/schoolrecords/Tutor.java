package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taughtSubject = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Tutor(String name, List<Subject> taughtSubject) {
        this.name = name;
        this.taughtSubject = taughtSubject;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        for (Subject item : taughtSubject) {
            if (item.getSubjectName().equals(subject.getSubjectName())) {
                return true;
            }
        }
        return false;
    }
}
