package exam02;

import java.util.ArrayList;
import java.util.List;

public class ArraySelector {
    public String selectEvens(int[] inputArray) {
        if (inputArray.length == 0) {
            return "";
        }
        List<Integer> selected = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (i % 2 == 0) {
                selected.add(inputArray[i]);
            }
        }
        return selected.toString();
    }
}
