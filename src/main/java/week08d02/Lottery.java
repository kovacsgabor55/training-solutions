package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Lottery {

    private Lottery() {
    }

    public static List<Integer> getNumbers(int interval, int numbers) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        while (randomNumbers.size() < numbers) {
            int number = random.nextInt(interval) + 1;
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
        return randomNumbers;
    }

    public static List<Integer> getNumbersk(int interval, int numbers) {
        List<Integer> result = new ArrayList<>(numbers);

        for (int i = 0; i < numbers; i++) {
            result.add(generateNumberNotInList(result, interval));
        }
        return result;
    }

    private static Integer generateNumberNotInList(List<Integer> myList, int interval) {
        Random random = new Random(5);
        int number = random.nextInt(interval) + 1;
        while (myList.contains(number)) {
            number = random.nextInt(interval) + 1;
        }
        return number;
    }

    public static void main(String[] args) {
        Lottery.getNumbers(90, 5);
        Lottery.getNumbersk(90, 5);
    }
}
