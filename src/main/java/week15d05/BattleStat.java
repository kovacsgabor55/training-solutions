package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Map;
import java.util.TreeMap;

public class BattleStat {
    private static final Charset utf8 = StandardCharsets.UTF_8;

    private int maxBattle = 0;

    public Map<String, Integer> readFile() {
        Path file = Path.of("src/main/resources/battles.csv");
        Map<String, Integer> cases = new TreeMap<>();

        int actual;
        try (BufferedReader bf = Files.newBufferedReader(file, utf8)) {
            String line;
            bf.readLine();
            while ((line = bf.readLine()) != null) {
                String[] temp = line.split(",");
                for (int i = 5; i < 13; i++) { // Set kivedheto lenne a defender és attacker ugyanaz
                    if (temp[i] == null || temp[i].isEmpty()) {
                        continue;
                    }
                    if (!cases.containsKey(temp[i])) {
                        cases.put(temp[i], 1);
                    } else {
                        actual = cases.get(temp[i]);
                        cases.replace(temp[i], actual + 1);
                        if (actual > maxBattle) {
                            maxBattle = actual + 1;
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found", ioe);
        }
        return cases;
    }

    public Map.Entry<String, Integer> maxBattles(Map<String, Integer> battles) {
        for (Map.Entry<String, Integer> battle : battles.entrySet()) {
            if (battle.getValue() == maxBattle) {
                return battle;
            }
        }
        throw new IllegalStateException("No maximum");
    }


    public static void main(String[] args) {
        BattleStat bt = new BattleStat();
        System.out.println(bt.maxBattles(bt.readFile()));
    }
}
