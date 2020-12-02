package week06d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordEraserTest {
    WordEraser wr;
    String original;
    String pattern;
    String expected;

    @BeforeEach
    void setUp() {
        wr = new WordEraser();
        original = "barack alma körte szilva alma bírsalma";
        pattern = "alma";
        expected = "barack körte szilva bírsalma";
    }

    @Test
    void eraseWord() {
        Assertions.assertEquals(wr.eraseWord(original, pattern), expected);
    }
}