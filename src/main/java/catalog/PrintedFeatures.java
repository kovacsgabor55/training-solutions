package catalog;

import java.util.List;

public class PrintedFeatures implements Feature {
    private String title;
    private int numberOfPages;
    private List<String> author;

    public PrintedFeatures(List<String> author) {
        if (Validators.isEmpty(author)) {
            throw new IllegalArgumentException();
        }
        this.author = author;
    }

    public PrintedFeatures(String title, int numberOfPages, List<String> author) {
        this(author);
        if (numberOfPages < 0) {
            throw new IllegalArgumentException();
        }
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public List<String> getContributors() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
