package week08d05;

public final class MathAlgorithms {
    private MathAlgorithms() {
    }

    public static int greatestCommonDivisor(int number1, int number2) {
        if (number1 <= 0 || number2 <= 0) {
            throw new IllegalArgumentException("a or b never used 0");
        }
        int tmp = 1;
        if (number1 < number2) {
            tmp = number1;
            number1 = number2;
            number2 = tmp;
        }
        while (tmp != 0) {
            tmp = number1 % number2;
            number1 = number2;
            number2 = tmp;
        }
        return Math.abs(number1);
    }
}
