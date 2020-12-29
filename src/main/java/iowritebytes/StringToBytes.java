package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

    public void writeAsBytes(List<String> words, Path path) {
        try (OutputStream os = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (String item : words) {
                if (!item.startsWith("_")) {
                    os.write(item.getBytes(StandardCharsets.UTF_8));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
