package methodparam.measuring;

public class Measurement {
    //1 virusosan jött vissza
    private double[] measures;

    public Measurement(double[] measures) {
        this.measures = measures;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < measures.length; i++) {
            if (lower < measures[i] && upper > measures[i]) {
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double min = measures[0];
        for (double item : measures) {
            if (min > item) {
                min = item;
            }
        }
        return min;
    }

    public double maximum() {
        double max = measures[0];
        for (double item : measures) {
            if (max < item) {
                max = item;
            }
        }
        return max;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }
}
