package week13d05;

import java.util.*;

public class Chars {

    public int sumOfLetters(String str) {
        Set<Character> characters = new HashSet<>();
        String lowerCaseStr = str.toLowerCase();

        for (Character c : lowerCaseStr.toCharArray()) {
            if (isEnglishLowerCaseChar(c)) {
                characters.add(c);
            }
        }
        return characters.size();
    }

    private boolean isEnglishLowerCaseChar(char c) {
        return (c >= 'a' && c <= 'z');
    }
}
