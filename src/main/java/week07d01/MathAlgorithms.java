package week07d01;

public class MathAlgorithms {
    private MathAlgorithms() {
    }

    public static boolean isPrime(long x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Number cannot be zero or less!");
        }
        if (x % 2 == 0 && x != 2 || x == 1) {
            return false;
        }
        long limit = (long) Math.floor(Math.sqrt(x));
        for (long division = 3; division <= limit; division += 2) {
            if (x % division == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime2(int x) {
        if (x < 1) {
            throw new IllegalArgumentException("Wrong parameter!");
        }
        int divisors = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                divisors++;
            }
        }
        if (divisors == 2) {
            return true;
        }
        return false;
    }

    public static boolean isPrimeOtherWay(int x) {
        if (x < 1) {
            throw new IllegalArgumentException("Wrong param");
        }
        if (x == 1) {
            return false;
        }
        if (x == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
