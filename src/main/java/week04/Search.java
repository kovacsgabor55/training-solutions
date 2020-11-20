package week04;

import java.util.ArrayList;
import java.util.List;

public class Search {
    public static void main(String[] args) {


    }

    List<Integer> getIndexesOfChar(String str, char c) {
        List<Integer> result = new ArrayList<>();
        boolean out = true;
        int from = 0;
        while (out) {
            int a = str.indexOf(c, from);
            if (a != -1) {
                result.add(a);
                from = a;
            } else {
                out = false;
            }
            return result;
        }
        return result;
    }

}