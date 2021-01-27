package collectionsset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {
    public Set<String> filterUniqueStrings(Collection<String> stringCollection) {
        Set<String> ret = new HashSet<>();
        for (String item : stringCollection) {
            ret.add(item);
        }
        return ret;
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB) {
        Set<String> ret = new HashSet<>(setA);
        for (String item : setB) {
            ret.add(item);
        }
        return ret;
    }
}
