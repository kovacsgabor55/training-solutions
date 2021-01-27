package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String word) {

        if (word == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }

        StringBuilder sb = new StringBuilder(word);

        String a = word.trim().toUpperCase();
        String b = sb.reverse().toString().trim().toUpperCase();

        return a.equals(b);

    }
}
