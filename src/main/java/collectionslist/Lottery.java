package collectionslist;

import java.util.*;

public class Lottery {
    Random random = new Random();

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {

        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        Set<Integer> lottery = new HashSet<>();

        while (lottery.size() < lotteryType) {
            int i = random.nextInt(ballCount) + 1;
            lottery.add(i);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer item : lottery) {
            res.add(item);
        }
        Collections.sort(res);
        return res;
    }
}
