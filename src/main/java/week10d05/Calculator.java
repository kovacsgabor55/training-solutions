package week10d05;

import java.util.*;

public class Calculator {
    public int findMinSum(int[] arr) {
        if (arr.length < 4) {
            throw new IllegalArgumentException("too small array");
        }
        int[] sorted = arr;
        Arrays.sort(sorted);
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += sorted[i];
        }
        return sum;

    }
}
