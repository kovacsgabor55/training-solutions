package ioreadbytes.bytematrix;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {
    private List<byte[]> myMatrix;

    public MatrixReader() {
        this.myMatrix = new ArrayList<>();
    }

    public List<byte[]> getMyMatrix() {
        return new ArrayList<>(myMatrix);
    }

   /* public int numberOfColumnsWhereMoreZeros() {
        int max = 0;
        for (byte[] item : myMatrix) {
            int tmp = 0;
            for (byte dat : item) {
                if (dat == 0) {
                    tmp++;
                }
            }
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }*/

    public void readBytesAndCreateMatrix(String filename) {
        try (InputStream is = new FileInputStream("src/main/resources/" + filename)) {
            byte[] dat = new byte[1000];
            while (is.read(dat) > 0) {
                myMatrix.add(dat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
