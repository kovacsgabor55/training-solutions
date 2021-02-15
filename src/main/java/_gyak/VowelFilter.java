package _gyak;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VowelFilter {
    private final static String[] LETTER = {"a", "á", "e", "é", "i", "í", "o", "ó", "ö", "ő", "u", "ú", "ü", "ű"};

    public String filterFowels(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                for (String item : LETTER) {
                    line = line.replace(item, "");
                    line = line.replace(item.toUpperCase(), "");
                }
                sb.append(line);
                sb.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        VowelFilter vowelFilter = new VowelFilter();
        try (BufferedReader br = Files.newBufferedReader(Path.of("VowelFilter.txt"))) {
            System.out.println(vowelFilter.filterFowels(br));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
