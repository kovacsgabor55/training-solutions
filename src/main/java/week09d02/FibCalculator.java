package week09d02;

public final class FibCalculator {
    private FibCalculator() {
    }

    public static long sumEvens(long bound) {
        long sum = 0;
        long fib = 0;
        for (int i = 0; bound >= (fib = fiboCalculator(i)); i++) {
            if (fib % 2 == 0) {
                sum += fib;
            }
        }
        return sum;
    }

    private static long fiboCalculator(long number) {
        if ((0 == number) || (1 == number)) {
            return number;
        } else {
            return fiboCalculator(number - 1) + fiboCalculator(number - 2);
        }
    }
}
