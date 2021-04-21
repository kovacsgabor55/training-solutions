package gtaiiiscriptcompose;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Progressor {
    private static List<String> fileList = new ArrayList<>();

    public static boolean loadFileList(String filename) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(filename))) {
            String fileString;
            while ((fileString = br.readLine()) != null) {
                fileList.add(fileString);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File list file not fount! ", e);
        }
        return (!fileList.isEmpty());
    }

    public static void compose() {
        for (String item : fileList) {
            composeFile(item);
        }
    }

    private static void composeFile(String filename) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(filename));
             BufferedWriter bw = Files.newBufferedWriter(Path.of("main.sc"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.write("\n");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File error ", e);
        }
    }
}
