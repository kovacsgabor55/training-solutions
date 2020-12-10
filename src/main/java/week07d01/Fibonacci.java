package week07d01;

public class Fibonacci {
    private Fibonacci() {
    }

    static long fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
