package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextCounter {
    public int countText(Path path, String text) {
        int counted = 0;
        String line;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            while ((line = br.readLine()) != null) {

        if(line.toLowerCase().contains(text.toLowerCase())){
            counted++;
        }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counted;
    }

    public static void main(String[] args) {
        Path path=Path.of("src","main","Resources","index.html");

        System.out.println(new TextCounter().countText(path,"Koronavírus"));
    }
}
