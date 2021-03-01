package covid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Convert {
    private static List<ZipCode> zipCodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Path.of("main.csv"))) {
            String lines;
            ZipCode zipCode;
            while ((lines = br.readLine()) != null) {
                String[] data = lines.split(",");
                if (data.length == 3) {
                    zipCode = new ZipCode(Integer.parseInt(data[0]), data[1], data[2]);
                } else {
                    zipCode = new ZipCode(Integer.parseInt(data[0]), data[1], "");
                }
                if (!zipCodes.contains(zipCode)) {
                    zipCodes.add(zipCode);
                }
            }
            Collections.sort(zipCodes, (o1, o2) -> {
                if (o1.getZipCode() < o2.getZipCode()) {
                    return -1;
                } else if (o1.getZipCode() > o2.getZipCode()) {
                    return 1;
                } else {
                    return o1.getDistrict().compareTo(o2.getDistrict());
                }
            });
            try (BufferedWriter bw = Files.newBufferedWriter(Path.of("converted.csv"))) {
                for (ZipCode item : zipCodes) {
                    bw.write(item.getZipCode() + "," + item.getCity() + "," + item.getDistrict() + "\n");
                }
            }

            for (int i = 0; i < 1000; i++) {
                System.out.println(zipCodes.get(new Random().nextInt(3045)).getZipCode());
            }
        }
    }
}
