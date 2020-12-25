package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {
    public void newMark(Path file, int mark) {
        try {
            if (Files.exists(file)) {
                Files.writeString(file, String.valueOf(mark) + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(file, String.valueOf(mark));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void average(Path file) {
        double avgtmp = 0;
        int count = 0;
        try {
            List<String> data = Files.readAllLines(file);
            for (String item : data) {
                avgtmp += Double.parseDouble(item);
                count++;
            }
            Files.writeString(file, "average: " + avgtmp / count + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
