package collectionsset;

import java.util.Set;
import java.util.TreeSet;

public class WordFilter {
    public Set<String> filterWords(String[] randomStrings) {
        Set<String> ret = new TreeSet<>();
        for (String item : randomStrings) {
            ret.add(item);
        }
        return ret;
    }
}
