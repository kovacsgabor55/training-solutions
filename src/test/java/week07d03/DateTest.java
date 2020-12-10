package week07d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    Date date = null;

    @BeforeEach
    void setUp() {
        date = Date.of(2020, 12, 24);
    }

    @Test
    void of() {
        assertEquals("Date{year=2020, month=12, day=24}", date.toString());
    }

    @Test
    void withYear() {
        date = date.withYear(2019);
        assertEquals("Date{year=2019, month=12, day=24}", date.toString());
    }

    @Test
    void withMonth() {
        date = date.withMonth(11);
        assertEquals("Date{year=2020, month=11, day=24}", date.toString());
    }

    @Test
    void withDay() {
        date = date.withDay(14);
        assertEquals("Date{year=2020, month=12, day=14}", date.toString());
    }
}