package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {
    public void saveShoppingList(OutputStream os, List<String> shoppingList) {
        try (PrintStream ps = new PrintStream(new BufferedOutputStream(os))) {
            for (String item : shoppingList) {
                ps.println(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<String> loadShoppingList(InputStream is) {
        List<String> shoppingList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                shoppingList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shoppingList;
    }
}
