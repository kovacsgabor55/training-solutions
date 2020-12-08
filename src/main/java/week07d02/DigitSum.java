package week07d02;

public class DigitSum {
    private DigitSum() {
    }

    public static int sumOfDigits(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Number cannot less zero!");
        }
        String strnum = Integer.toString(x);
        int sum = 0;
        for (int i = 0; i < strnum.length(); i++) {
            sum += Integer.parseInt(strnum.substring(i, i + 1));
        }
        return sum;
    }
}