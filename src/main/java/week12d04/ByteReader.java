package week12d04;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteReader {
    private static final Path path = Path.of("src", "main", "resources", "secret.dat");

    public static void main(String[] args) {
        String result = new ByteReader().printSecret(path);
        System.out.println(result);
        String result2 = new ByteReader().prn(path);
        System.out.println(result2);
    }

    public String printSecret(Path path) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] bytes = Files.readAllBytes(path);
            for (byte b : bytes) {
                char c = (char) (b + 10);
                sb.append(c);

            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
        return sb.toString();
    }

    public String prn(Path path) {
        StringBuilder sb = new StringBuilder();
        try (InputStream is = Files.newInputStream(path)) {
            byte[] buffer = new byte[1000];
            int size;
            while ((size = is.read(buffer)) > 0) {
                for (int i = 0; i < size; i++) {
                    char c = (char) (buffer[i] + 10);
                    sb.append(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}






























