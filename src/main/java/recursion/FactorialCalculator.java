package recursion;

public class FactorialCalculator {

    public long getFactorial(int number) {
        if (number > 0) {
            long f = number * getFactorial(number - 1);
            return f;
        }
        return 1;
    }
}
