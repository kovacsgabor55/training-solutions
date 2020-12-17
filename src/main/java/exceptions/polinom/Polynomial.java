package exceptions.polinom;

import java.util.Objects;

public class Polynomial {
    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        Objects.requireNonNull(coefficients, "coefficients is null");
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficients) {
        Objects.requireNonNull(coefficients, "coefficientStrs is null");
        this.coefficients = new double[coefficients.length];
        try {
            for (int i = 0; i < coefficients.length; i++) {
                this.coefficients[i] = Double.parseDouble(coefficients[i]);
            }
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", n);
        }
    }

    public double evaluate(double x) {
        double sum = 0;
        for (int j = coefficients.length - 1; j >= 0; j--) {
            sum += coefficients[j] * Math.pow(x, (double) coefficients.length - 1 - j);
        }
        return sum;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}
