package ioreadbytes.byteacount;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteChecker {
    public int readBytesAndFindAs(String file) {
        int count = 0;
        try (InputStream is = new FileInputStream("src/main/resources/" + file)) {
            byte[] bytes = new byte[1000];
            while (is.read(bytes) > 0) {
                for (byte item : bytes) {
                    if (item == 97) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
