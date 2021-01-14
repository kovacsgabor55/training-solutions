package week11d04;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {
    String FILE_PREFIX = "number";

    public int sumNumbers() {
        int sum=0;
        String fileName;
        for (int i = 0; i <= 99; i++) {
            fileName = String.format("number%02d.txt", i);
            //"number" + (i<10?"0"+1:i)+"txt";
            if (isFileExist(fileName)) {
                sum += readFileNumber(fileName);
            }
        }

        return sum;
    }

    private int readFileNumber(String fileName) {
        try {
            String content = Files.readString(Path.of(fileName));
            return Integer.parseInt(content);
        } catch (IOException e) {
            throw new IllegalArgumentException("Can not read", e);
        }
    }

    private boolean isFileExist(String fileName) {
        System.out.println(Path.of(fileName).toString());
        return Files.isRegularFile(Path.of(fileName));
    }

    public static void main(String[] args) {
        System.out.println(new FilesSum().sumNumbers());
    }
}
