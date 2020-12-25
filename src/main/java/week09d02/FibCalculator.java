package week09d02;

public final class FibCalculator {
    private static int[] FIB_NUMS = new int[1000];

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

    static long sumEvens2(int bound) {
        int sum = 0;
        int fibN = 0;
        while (fib(fibN) < bound) {
            if (FIB_NUMS[fibN] % 2 == 0) {
                sum += FIB_NUMS[fibN];
            }
        }
        return sum;
    }

    static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if (FIB_NUMS[n] == 0) {
                FIB_NUMS[n] = fib(n - 1) + fib(n - 2);
            }
            return FIB_NUMS[n];
        }
    }
}
