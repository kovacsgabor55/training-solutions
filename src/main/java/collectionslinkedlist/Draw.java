package collectionslinkedlist;

import java.util.*;

public class Draw {
    Random random = new Random();

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then "+drawCount+"!");
        }
        Set<Integer> drawedNumber = new TreeSet<>();

        while (drawedNumber.size() < drawCount) {
            int i = random.nextInt(maxNumber) + 1;
            drawedNumber.add(i);
        }
        return drawedNumber;
    }
}
