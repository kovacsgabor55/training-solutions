package week14d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s;

    @BeforeEach
    void setUp() {
        s = new Student("John");
    }

    @Test
    void createTest() {
        assertEquals("John", s.getName());
        assertEquals(0, s.getNotes().size());
    }

    @Test
    void addNoteTest() {
        s.addNote("math", 5);

        assertEquals(1, s.getNotes().size());
        assertEquals(5, s.getNotes().get("math").get(0));

        s.addNote("math", 4);
        assertEquals(2, s.getNotes().get("math").size());

        s.addNote("biology", 4);
        assertEquals(2, s.getNotes().size());
        assertEquals(4, s.getNotes().get("biology").get(0));
    }
}
