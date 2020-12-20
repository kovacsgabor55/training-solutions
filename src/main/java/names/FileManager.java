package names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    Path myFile;
    List<Human> humans;

    public FileManager(String myFile) {
        this.myFile = Path.of(myFile);
        humans = new ArrayList<>();
    }

    public void readFromFile() {
        List<String> readed = null;
        try {
            readed = Files.readAllLines(myFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String item : readed) {
            String[] splitted = item.split(" ");
            humans.add(new Human(splitted[0], splitted[1]));
        }
    }

    public Path getMyFile() {
        return myFile;
    }

    public List<Human> getHumans() {
        return humans;
    }
}
