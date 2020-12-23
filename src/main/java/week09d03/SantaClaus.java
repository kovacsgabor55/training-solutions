package week09d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {
    private List<Person> people;

    public SantaClaus(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }

    public void getThroughChimneys() {
        for (Person item : people) {
            item.setPresent();
        }
    }
}
