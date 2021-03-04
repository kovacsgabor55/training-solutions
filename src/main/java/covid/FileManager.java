package covid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public List<Citizen> loadCitizenToFile(BufferedReader reader) {
        List<Citizen> result = new ArrayList<>();
        try {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String name = data[0];
                int zip = Integer.parseInt(data[1]);
                int age = Integer.parseInt(data[2]);
                String email = data[3];
                String mr = data[4];
                result.add(new Citizen(name, zip, age, email, mr));
            }
        } catch (IOException e) {
            throw new IllegalStateException("File error", e);
        }
        return result;
    }

    public void saveCitizenToFile(List<Citizen> citizens, int zipCode) {
        LocalTime time = LocalTime.of(8, 0);
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(zipCode + ".csv"))) {
            bw.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
            for (Citizen item : citizens) {
                bw.write(String.format("%02d", time.getHour()));
                bw.write(":");
                bw.write(String.format("%02d", time.getMinute()));
                bw.write(";");
                bw.write(item.getFullName());
                bw.write(";");
                bw.write(String.valueOf(item.getZipCode()));
                bw.write(";");
                bw.write(String.valueOf(item.getAge()));
                bw.write(";");
                bw.write(item.getEmail());
                bw.write(";");
                bw.write(item.getMedicalRecord());
                bw.newLine();
                time = time.plusMinutes(30);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot save file", e);
        }
    }
}
