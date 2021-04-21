package filemanipulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        ManipulateData md = new ManipulateData();
        try (BufferedReader br = Files.newBufferedReader(Path.of("relacelist.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                md.SpiltUpdate(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = Files.newBufferedReader(Path.of("deletelist.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                md.SpiltUpdate(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
