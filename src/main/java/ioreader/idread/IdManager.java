package ioreader.idread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IdManager {
    private List<String> ids;

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }

    public IdManager() {
        this.ids = new ArrayList<>();
    }

    public void readIdsFromFile(String file) {
        String data;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + file))) {
            while ((data = br.readLine()) != null) {
                ids.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
