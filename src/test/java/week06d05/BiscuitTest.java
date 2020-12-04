package week06d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week06d04.Budget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BiscuitTest {
    private Biscuit biscuit;

    @BeforeEach
    void setUp() {
        biscuit = Biscuit.of(BiscuitType.HONEY, 1200);
    }

    @DisplayName("Biscuit create 'of' test")
    @Test
    void ofTest() {
        Assertions.assertEquals(BiscuitType.HONEY, biscuit.getType());
        Assertions.assertEquals(1200, biscuit.getGramAmount());
    }

    @DisplayName("Biscuit create 'of' test")
    @Test
    void toStringTest() {
        Assertions.assertEquals("Biscuit{type=HONEY, gramAmount=1200}", biscuit.toString());
    }

    @Test
    void grammInvalidTest() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> Biscuit.of(BiscuitType.HONEY, 0));
        assertEquals("gramAmount canot be Zero or less!", ex.getMessage());
    }
}