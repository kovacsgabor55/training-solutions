package week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {
    public List<String> wordsWithChar(List<String> words, char c) {
        List<String> result = new ArrayList<>();
        if (words == null) return result;

        for (String word : words) {
            if (word != null && word.indexOf(c) >= 0) {
                result.add(word);
            }
        }
        return result;
    }
}
