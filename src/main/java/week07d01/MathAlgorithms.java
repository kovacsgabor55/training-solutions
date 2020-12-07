package week07d01;

public class MathAlgorithms {


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
}
