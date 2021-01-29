package week13d05;

import java.util.Objects;

public class CountedChar {
    int count=1;
    char character;

    public CountedChar(char character) {
        this.character = character;
    }

    public int getCount() {
        return count;
    }

    public char getCharacter() {
        return character;
    }

    public void stepCount() {
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountedChar that = (CountedChar) o;
        return character == that.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }
}
