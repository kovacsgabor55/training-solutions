package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {
    private String registrationNumber;
    private int price;
    private List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features.addAll(Arrays.asList(features));
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    //FIXME
    public int numberOfPagesAtOneItem() {
        return 0;
    }

    //FIXME
    public int fullLengthAtOneItem() {
        return 0;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (Feature item : features) {
            contributors.addAll(item.getContributors());
        }
        return contributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature item : features) {
            titles.add(item.getTitle());
        }
        return titles;
    }

    //FIXME
    public boolean hasAudioFeature() {
        return false;
    }

    //FIXME
    public boolean hasPrintedFeature() {
        return false;
    }
}