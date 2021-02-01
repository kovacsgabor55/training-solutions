package week14d01;

import java.util.*;

public class Indexer {
    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        List<String> value;
        for (String item : names) {
            char key = item.toCharArray()[0];
            if (result.containsKey(key)) {
                value = result.get(key);
                value.add(item);
                result.replace(key, value);
            } else {
                value = new ArrayList<>();
                value.add(item);
                result.put(key, value);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna")));
        System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Ludmilla", "Abraham", "Adam", "Ajtony", "Magdolna")));
        // {A=[Abraham], L=[Lujza], M=[Magdolna], O=[Odon]} 11:55 -> 12:16
    }
}
