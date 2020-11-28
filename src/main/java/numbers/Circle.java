package numbers;


import static java.lang.StrictMath.pow;

public class Circle {
    private int diameter;
    private static final double Pi = 3.14;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter() {
        return diameter * Pi;
    }

    public double area() {
        return pow(((double) diameter / 2), 2) * Pi;
    }
}
