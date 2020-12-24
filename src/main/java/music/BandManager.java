package music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
    private List<Band> bands;

    public BandManager() {
        bands = new ArrayList<>();
    }

    public void readBandsFromFile(Path inputFile) {
        try (BufferedReader br = Files.newBufferedReader(inputFile)) {
            String lines;
            while ((lines = br.readLine()) != null) {
                String[] data = lines.split(";");
                bands.add(new Band(data[0], Integer.parseInt(data[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeBandsBefore(Path outputFile, int year) {
        List<Band> beforeYears = new ArrayList<>();
        for (Band item : bands) {
            if (item.getYear() < year) {
                try (BufferedWriter bw = Files.newBufferedWriter(outputFile, StandardOpenOption.APPEND)) {
                    bw.write(item.getName() + ";" + item.getYear() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
