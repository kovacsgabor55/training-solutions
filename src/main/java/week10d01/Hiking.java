package week10d01;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Hiking {

    public static double getPlusElevation(List<Double> elevations) {
        double sumElevation = 0;
        double actual = elevations.get(0);
        for (double item : elevations) {
            if (actual < item) {
                sumElevation += item - actual;
            }
            actual = item;
        }
        return sumElevation;
    }

    public static Difference getPlusElevation(InputStream is) {
        try (DataInputStream dis = new DataInputStream(is)) {
            String line;
            double sumElevation = 0;
            double sumDepth = 0;
            List<Integer> elevations = new ArrayList<>();
            while ((line = dis.readLine()) != null) {
                elevations.add(Integer.parseInt(line.split(", ")[2]));
            }
            int actual = elevations.get(0);
            for (int item : elevations) {
                if (actual < item) {
                    sumElevation += item - actual;
                } else {
                    sumDepth += actual - item;
                }
                actual = item;
            }
            return new Difference(sumElevation, sumDepth);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        InputStream is = Files.newInputStream(Path.of("src/main/resources/GPSdata.txt"));
        List<Double> ele = new ArrayList<>(List.of(10d, 20d, 15d, 18d));
        System.out.println(getPlusElevation(ele));
        Difference difference = getPlusElevation(is);
        System.out.println(difference.getDepth());
        System.out.println(difference.getElevation());

    }
}
