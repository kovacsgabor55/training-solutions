package week06d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListSelectorTest {
    ListSelector listSelector = new ListSelector();
    List<String> oddSizeStringList;
    List<String> evenSizeStringList;

    @DisplayName("Initialization")
    @BeforeEach
    void setUp() {
        oddSizeStringList = Arrays.asList("first", "second", "third");
        evenSizeStringList = Arrays.asList("first", "second", "third", "fourth");
    }

    @DisplayName("odd size list")
    @Test
    void oddSizeList() {
        Assertions.assertEquals("[first,third]", listSelector.evenIndexString(oddSizeStringList));
    }

    @DisplayName("even size list")
    @Test
    void evenSizeList() {
        Assertions.assertEquals("[first,third]", listSelector.evenIndexString(evenSizeStringList));
    }

    @DisplayName("even size list")
    @Test
    void emptyList() {
        Assertions.assertEquals("", listSelector.evenIndexString(new ArrayList<String>()));
    }

    @DisplayName("null list")
    @Test
    void nullList() {
        Exception ex = assertThrows(NullPointerException.class, () -> listSelector.evenIndexString(null));
        assertEquals("List cannot be null!", ex.getMessage());
    }
}