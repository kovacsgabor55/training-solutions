package week11d01;

public class DivisorFinder {
    public int findDivisors(int n) {
        String[] numbers = Integer.toString(n).split("");
        int count = 0;
        for (String item : numbers) {
            if (Integer.parseInt(item) == 0) {
                continue;
            }
            if (n % Integer.parseInt(item) == 0) {
                count++;
            }
        }
        return count;
    }
}
