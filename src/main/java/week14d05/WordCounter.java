package week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public Map<String, Integer> countWords(String fileName, String... words) {
        Path fn = Path.of(fileName);

        Map<String, Integer> result = new HashMap<>();
        for (String item : words) {
            result.put(item, 0);
        }

        try (BufferedReader br = Files.newBufferedReader(fn, Charset.forName("iso-8859-2"))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String item : words) {
                    if (line.contains(item)) {
                        result.replace(item, result.get(item) + 1);
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file: " + fileName, e);
        }

        return result;
    }

    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
        System.out.println(wc.countWords("src/main/resources/hachiko.srt", "Hachiko", "haza", "pályaudvar", "jó"));
    }
}
