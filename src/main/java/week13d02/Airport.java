package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Airport {
    private List<Catalog> catalogs = new ArrayList<>();

    public List<Catalog> getCatalogs() {
        return new ArrayList<>(catalogs);
    }

    public void loadFile(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("invalid filename");
        }
        Path path = Path.of(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split(" ");
                addCatalog(splitted);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCatalog(String[] data) {
        //FC5354 Arrival Dublin 18:16
        String flyNumber = data[0];
        String direction = data[1];
        String city = data[2];
        int hours = Integer.parseInt(data[3].split(":")[0]);
        int minutes = Integer.parseInt(data[3].split(":")[1]);
        catalogs.add(new Catalog(flyNumber, direction, city, hours, minutes));
    }

    public String moreDirection() {
        int arr = 0;
        int halfSize = catalogs.size() / 2;
        for (Catalog item : catalogs) {
            if (item.getDirection().equals("Arrival")) {
                arr++;
            }
            if (halfSize < arr) {
                return "Arrival";
            }
        }
        return (arr == halfSize) ? "Both" : "Departure";
    }

    public Catalog searchFlyNumber(String flyNr) {
        if (flyNr == null || flyNr.isBlank()) {
            throw new IllegalArgumentException("invalid flyNr");
        }
        for (Catalog item : catalogs) {
            if (item.getFlyNumber().equals(flyNr)) {
                return item;
            }
        }
        return null;
    }

    public List<Catalog> getCityToDirection(String city, String direction) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("invalid city");
        }
        if (direction == null) {
            throw new IllegalArgumentException("invalid city");
        }
        List<Catalog> result = new ArrayList<>();
        for (Catalog item : catalogs) {
            if (item.getCity().equals(city) && item.getDirection().equals(direction)) {
                result.add(item);
            }
        }
        return result;
    }

    public Catalog getFirstDepartures() {
        int min = getCatalogs().get(0).getHours() * 60 + getCatalogs().get(0).getMinutes();
        int minIndex = 0;
        for (int i = 1; i < catalogs.size(); i++) {
            int tmp = getCatalogs().get(i).getHours() * 60 + getCatalogs().get(i).getMinutes();
            if (min > tmp && getCatalogs().get(i).getDirection().equals("Departure")) {
                min = tmp;
                minIndex = i;
            }
        }
        return getCatalogs().get(minIndex);
    }


    public static void main(String[] args) {
        Airport ari = new Airport();
        ari.loadFile("cities.txt");
        //System.out.println(ari.getCatalogs());
        //System.out.println(ari.getCatalogs().size());
        // System.out.println(ari.moreDirection());
        //System.out.println(ari.searchFlyNumber("JO3963"));
        System.out.println(ari.getCityToDirection("Bucharest", "Arrival").size());
        System.out.println(ari.getFirstDepartures());
    }

}
