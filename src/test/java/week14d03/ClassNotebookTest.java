package week14d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ClassNotebookTest {

    @Test
    void sortNotebookTest() {
        ClassNotebook cnb = new ClassNotebook(new ArrayList<>(List.of(new Student("John"), new Student("Bill"), new Student("Jane"))));

        List<Student> result = cnb.sortNotebook();
        assertEquals("Bill", result.get(0).getName());
        assertEquals("John", result.get(2).getName());

        result.add(new Student("Jack"));
        assertEquals(3, cnb.getStudents().size());

        result.get(0).addNote("math", 5);
        assertEquals(0, cnb.getStudents().get(1).getNotes().size());
    }
}
