package week05d03;

import java.util.Arrays;
import java.util.List;

public class ListCounter {
    static final List<String> teszt = Arrays.asList("abc", "Abc", "hAij", "nrao");
    static final char LETTER = 'A';

    public static void main(String[] args) {
        ListCounter listCounter = new ListCounter();
        System.out.println(listCounter.listCountaA(teszt));
    }

    public int listCountaA(List<String> src) {
        int count = 0;
        if (src.isEmpty() || src == null) {
            return count;
        }
        for (String item : src) {
            if (item.toUpperCase().indexOf(LETTER) == 0) {
                count++;
            }
        }
        return count;
    }

    public int startsWithACounter(List<String> words) {
        int counter = 0;
        for (String s : words) {
            if (s.toUpperCase().charAt(0) == 'A') {
                counter++;
            }
        }
        return counter;
    }
}
