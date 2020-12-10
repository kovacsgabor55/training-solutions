package week07d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LabTest {
    LocalDate localDate;
    Lab lab1;
    Lab lab2;

    @BeforeEach
    void setUp() {
        localDate = LocalDate.of(2020, 12, 24);
        lab1 = new Lab("title1");
        lab2 = new Lab("title2", localDate);
    }

    @DisplayName("constructor test")
    @Test
    void labConstructorTest() {
        assertEquals("Lab{title='title1', completed=false, completedAt=null}", lab1.toString());
        assertEquals("Lab{title='title2', completed=false, completedAt=2020-12-24}", lab2.toString());
    }

    @DisplayName("completed test")
    @Test
    void completeTest() {
        lab1.complete(localDate);
        assertEquals("Lab{title='title1', completed=true, completedAt=2020-12-24}", lab1.toString());
    }

    @DisplayName("completed now test")
    @Test
    void completeNowTest() {
        lab1.complete();
        assertEquals("Lab{title='title1', completed=true, completedAt=" + LocalDate.now() + "}", lab1.toString());
    }
}