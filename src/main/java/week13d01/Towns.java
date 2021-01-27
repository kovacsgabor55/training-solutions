package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Towns {

    public String longestTownName(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            return longestName(br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private void skipheader(BufferedReader br) throws IOException {
        br.readLine();
    }

    private String longestName(BufferedReader br) throws IOException {
        int max = 0;
        String longest = "";
        skipheader(br);
        String line;
        while ((line = br.readLine()) != null) {
            int index1 = line.indexOf(";");
            int index2 = line.indexOf(";", index1 + 1);
            String town = line.substring(index1 + 1, index2);
            if (town.length() > max) {
                max = town.length();
                longest = town;
            }
        }
        return longest;
    }
}
