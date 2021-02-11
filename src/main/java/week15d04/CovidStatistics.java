package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CovidStatistics {
    private final List<CovidCaseByWeek> cases = new ArrayList<>();

    public void readFromFile(BufferedReader br) {
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Hungary")) {
                    cases.add(processLine(line));
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Fail at reading!");
        }
    }

    private CovidCaseByWeek processLine(String line) {
        String[] temp = line.split(",");
        int numberOfCases = Integer.parseInt(temp[2]);
        return new CovidCaseByWeek(temp[1], numberOfCases);
    }

    public List<String> findFirstThree() {
        List<CovidCaseByWeek> sorted = new ArrayList<>(cases);
        Collections.sort(sorted);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(sorted.get(i).getWeek());
        }
        return result;
    }

    public List<CovidCaseByWeek> getCases() {
        return new ArrayList<>(cases);
    }

    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("data.csv"))) {
            CovidStatistics covidStatistics = new CovidStatistics();
            covidStatistics.readFromFile(br);
            System.out.println(covidStatistics.findFirstThree());
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot find File!");
        }
    }
}
