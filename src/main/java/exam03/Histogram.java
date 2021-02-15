package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {
    public String createHistogram(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                int data = Integer.parseInt(line);
                for (int i = 0; i < data; i++) {
                    sb.append('*');
                }
                sb.append('\n');
            }
        } catch (IOException e) {
            throw new IllegalStateException("Something happened!");
        }
        return sb.toString();
    }
}
