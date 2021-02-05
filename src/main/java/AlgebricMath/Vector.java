package AlgebricMath;

import org.jetbrains.annotations.Range;

import java.io.Serializable;
import java.util.Arrays;

public class Vector implements Serializable {
    private final double[] elements;

    public Vector(double... elements) {
        this.elements = elements;
    }

    public double[] getAllElements() {
        return elements;
    }

    public double getElement(@Range(from = 1, to = Integer.MAX_VALUE) int index) {
        if (getDimension() < index) {
            throw new InvalidDimensionException();
        }
        return elements[index];
    }

    public int getDimension() {
        return this.elements.length;
    }

    public static Vector getNullVector(@Range(from = 1, to = Integer.MAX_VALUE) int dimension) {
        return new Vector(new double[dimension]);
    }

    public static Vector getOnesVector(@Range(from = 1, to = Integer.MAX_VALUE) int dimension) {
        double[] result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            result[i] = 1;
        }
        return new Vector(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Arrays.equals(elements, vector.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
}
