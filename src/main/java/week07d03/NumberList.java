package week07d03;

import java.util.List;
import java.util.Objects;

public class NumberList {
    private NumberList() {
    }

    public static boolean isIncreasing(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "Numbers cannot be null.");
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Numbers cannot be empty!");
        }
        if (numbers.size() == 1) {
            return true;
        }
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) > numbers.get(i)) {
                return false;
            }
        }
        return true;
    }
}
