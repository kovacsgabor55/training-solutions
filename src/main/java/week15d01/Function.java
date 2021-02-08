package week15d01;

import java.util.HashMap;
import java.util.Map;

public class Function {
    public Map<Double, Double> functionGlobalMax(Map<Double, Double> input) {
        Map<Double, Double> result = new HashMap<>();
        double functionMaxValue = (Double) input.keySet().toArray()[0];
        double functionkey = (Double) input.values().toArray()[0];

        for (Double item : input.keySet()) {
            if (input.get(item) > functionMaxValue) {
                functionMaxValue = input.get(item);
                functionkey = item;
            }
        }
        result.put(functionkey, functionMaxValue);
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
}
