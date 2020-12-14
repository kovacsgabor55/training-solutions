package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private String title;
    private int length;
    private List<String> composer;
    private List<String> performers;

    public AudioFeatures(String title, int length, List<String> composer) {
        if (length < 0 || Validators.isBlank(title)) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.length = length;
        this.composer = composer;
    }

    public AudioFeatures(String title, int length, List<String> composer, List<String> performers) {
        this(title, length, composer);
        this.performers = performers;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        if (!Validators.isEmpty(performers)) {
            contributors.addAll(performers);
        }
        contributors.addAll(composer);
        return contributors;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
