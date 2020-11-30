package week06d01;

import java.util.List;
import java.util.Objects;

public class ListSelector {
    public String evenIndexString(List<String> strings) {
        Objects.requireNonNull(strings, "List cannot be null!");
        if (strings.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < strings.size(); i += 2) {
            stringBuilder.append(strings.get(i));
            if (!(i + 3 > strings.size())) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
