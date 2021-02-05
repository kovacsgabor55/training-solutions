package AlgebricMath;

import org.jetbrains.annotations.NotNull;

public class AMath {
    private AMath() {
    }

    public static Vector vectorMultiple(@NotNull Vector v1, @NotNull Vector v2) {
        if (v1.getDimension() != v2.getDimension()) {
            throw new InvalidDimensionException("v1 dimension=" + v1.getDimension() + " not equal v2 dimension=" + v2.getDimension() + ". " + v1.getDimension() + " \u2260 " + v2.getDimension());
        }
        double[] temp = v1.getAllElements();
        for (int i = 0; i < v2.getDimension(); i++) {
            temp[i] *= v2.getElement(i);
        }
        return new Vector(temp);
    }

    public static double vectorMultipleTransposed(@NotNull Vector v1, @NotNull Vector v2) {
        if (v1.getDimension() != v2.getDimension()) {
            throw new InvalidDimensionException("v1 dimension=" + v1.getDimension() + " not equal v2 dimension=" + v2.getDimension() + ". " + v1.getDimension() + " \u2260 " + v2.getDimension());
        }
        double result = 0;
        for (int i = 0; i < v1.getDimension(); i++) {
            result += v1.getElement(i) * v2.getElement(i);
        }
        return result;
    }
}
