package week08d03;

import java.util.ArrayList;
import java.util.List;

public final class StringLists {
    private StringLists() {
    }

    public static List<String> stringListsUnion(List<String> first, List<String> second) {
        List<String> union = new ArrayList<>();
        union.addAll(first);
        for (String item : second) {
            if (!union.contains(item)) {
                union.add(item);
            }
        }
        return union;
    }
}
