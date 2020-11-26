package week03;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Teszt osztály
class PhoneParserTest {
    // Teszt metódus == teszteset
    @Test
    void testPatsePhone() {
        //GIVEN - előkészítés
        PhoneParser phoneParser = new PhoneParser();
        //WHEN - metódus meghivása
        Phone phone = phoneParser.parsePhone("30-1234567");
        //THEN - ellenőrizzük
        assertEquals("30", phone.getPrefix());
        assertEquals("1234567", phone.getNumber());
        assertEquals("30-1234567", phone.toString());
    }
}
