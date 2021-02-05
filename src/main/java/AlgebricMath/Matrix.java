package AlgebricMath;

import org.jetbrains.annotations.Range;

public class Matrix {
    private double[][] elements;

    public Matrix(double[][] elements) {
        this.elements = elements;
    }

    public double[][] getElements() {
        return elements;
    }

    public double getElement(@Range(from = 1, to = Integer.MAX_VALUE) int dimensionColumn, @Range(from = 1, to = Integer.MAX_VALUE) int dimensionRow) {
        if (elements[0].length < dimensionColumn) {
            throw new InvalidDimensionException();
        }
        if (elements.length < dimensionRow) {
            throw new InvalidDimensionException();
        }
        return elements[dimensionColumn][dimensionRow];
    }

    public int getDimensionColumn() {
        return elements[0].length;
    }

    public int getDimensionRow() {
        return elements.length;
    }

    //a kisebb dimenzioig tolti fel egyesekkel
    public Matrix createOneDiagonal(@Range(from = 1, to = Integer.MAX_VALUE) int dimensionColumn, @Range(from = 1, to = Integer.MAX_VALUE) int dimensionRow) {
        int dimension = Math.min(dimensionColumn, dimensionRow);
        double[][] result = new double[dimensionColumn][dimensionRow];
        for (int i = 0; i < dimension; i++) {
            result[i][i] = 1;
        }
        return new Matrix(result);
    }

    //ha kevesebb elemet kap akkor a tobbi helyen nullakat hagy
    public Matrix createDiagonal(@Range(from = 1, to = Integer.MAX_VALUE) int dimensionColumn, @Range(from = 1, to = Integer.MAX_VALUE) int dimensionRow, double... elements) {
        if (dimensionColumn < elements.length) {
            throw new InvalidDimensionException();
        }
        if (dimensionRow < elements.length) {
            throw new InvalidDimensionException();
        }
        double[][] result = new double[dimensionColumn][dimensionRow];
        for (int i = 0; i < elements.length; i++) {
            result[i][i] = elements[i];
        }
        return new Matrix(result);
    }

    public Matrix createQuadraticOneDiagonal(@Range(from = 1, to = Integer.MAX_VALUE) int dimension) {
        double[][] result = new double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            result[i][i] = 1;
        }
        return new Matrix(result);
    }

    public Matrix createQuadraticDiagonal(double... elements) {
        int dimension = elements.length;
        double[][] result = new double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            result[i][i] = elements[i];
        }
        return new Matrix(result);
    }
}
