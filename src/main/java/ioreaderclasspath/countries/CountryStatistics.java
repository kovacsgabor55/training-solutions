package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    private List<Country> countryList;

    public CountryStatistics() {
        this.countryList = new ArrayList<>();
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Country.class.getResourceAsStream("/" + filename)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                countryList.add(new Country(data[0], Integer.parseInt(data[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int numberOFCountries() {
        return countryList.size();
    }

    public Country mostBorderCountries() {
        Country max = countryList.get(0);
        for (Country item : countryList) {
            if (max.getBorderCountries() < item.getBorderCountries()) {
                max = item;
            }
        }
        return max;
    }
}
