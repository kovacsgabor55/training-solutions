package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class OnlineShopping {

    private final Map<String, List<String>> shoppingMap = new HashMap<>();

    public Map<String, List<String>> getShoppingMap() {
        return shoppingMap;
    }

    public void loadFile(String filename) {
        Path path = Path.of(filename);
        try (BufferedReader bf = Files.newBufferedReader(path)) {
            String line;
            while ((line = bf.readLine()) != null) {
                addMap(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Something went wrong", ioe);
        }
    }

    private void addMap(String line) {
        String key = line.split(" ")[0];
        String[] productA = line.split(" ")[1].split(",");
        List<String> products = new ArrayList<>(Arrays.asList(productA));
        Collections.sort(products);
        shoppingMap.put(key, products);
    }

    public List<String> search(String iD) {
        if (shoppingMap.containsKey(iD)) {
            return shoppingMap.get(iD);
        } else {
            throw new IllegalArgumentException("Invalid Key");
        }
    }

    public int getNumberByOrderedId(String id) {
        return search(id).size();
    }

    public int getNumberOfOrderedProducts(String productName) {
        int counter = 0;
        Set<String> key = shoppingMap.keySet();
        for (String item : key) {
            if (search(item).contains(productName)) {
                counter++;
            }
        }
        return counter;
    }

    public Map<String, Integer> getProductsMap() {
        Set<String> products = new HashSet<>();
        for (List<String> items : shoppingMap.values()) {
            products.addAll(items);
        }
        Map<String, Integer> result = new HashMap<>();
        for (String item : products) {
            result.put(item, getNumberOfOrderedProducts(item));
        }
        return result;
    }
}
