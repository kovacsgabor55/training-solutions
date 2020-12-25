package talentshow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {
    private List<Production> productions;
    private List<Vote> votes;

    public ResultCalculator() {
        productions = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }

    public void readTalents(Path talentsFile) {
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(talentsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                productions.add(new Production(Integer.parseInt(data[0]), data[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calculateVotes(Path votesFile) {
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(votesFile))) {
            String data;
            while ((data = br.readLine()) != null) {
                int vid = Integer.parseInt(data);
                boolean exist = false;
                for (Vote v : votes) {
                    if (v.getId() == vid) {
                        v.incNum();
                        exist = true;
                    }
                }
                if (!exist) {
                    votes.add(new Vote(vid, 1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeResultToFile(Path resultFile) {
        /*try (BufferedWriter bw = new BufferedWriter(Files.newBufferedWriter(resultFile))) {
            for (:
                 ) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
