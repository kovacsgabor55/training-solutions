package week15d01;

import java.util.HashMap;
import java.util.Map;

public class Function {
    public Map<Double, Double> functionGlobalMax(Map<Double, Double> input) {
        Map<Double, Double> result = new HashMap<>();
        double functionMaxValue = (Double) input.keySet().toArray()[0];
        double functionKey = (Double) input.values().toArray()[0];

        for (Double item : input.keySet()) {
            if (input.get(item) > functionMaxValue) {
                functionMaxValue = input.get(item);
                functionKey = item;
            }
        }
        result.put(functionKey, functionMaxValue);
        return result;
    }

    public static void main(String[] args) {
        Map<Double, Double> in = new HashMap<>();
        in.put(5D, 8D);
        in.put(6D, 10D);
        in.put(7D, 9D);
        Function fn = new Function();
        System.out.println(fn.functionGlobalMax(in));
    }

    public Map.Entry<Double, Double> maxValueEntry(Map<Double, Double> graphOfFunction) {
        if (graphOfFunction.isEmpty() || graphOfFunction.containsValue(Double.MIN_VALUE)) {
            throw new IllegalArgumentException("Wrong param!");
        }
        Map.Entry<Double, Double> maxElement = null;
        for (Map.Entry<Double, Double> actual : graphOfFunction.entrySet()) {
            if (maxElement == null || maxElement.getValue() < actual.getValue()) {
                maxElement = actual;
            }
        }
        return maxElement;
    }
}
