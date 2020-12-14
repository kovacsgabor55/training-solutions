package catalog;

public class SearchCriteria {
    private String contributor;
    private String title;

    private SearchCriteria(String contributor, String title) {
        this.contributor = contributor;
        this.title = title;
    }

    public static SearchCriteria createByTitle(String title) {
        return createByBoth(title, "");
    }

    public static SearchCriteria createByContributor(String contributor) {
        return createByBoth("", contributor);
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (title == null || contributor == null) {
            throw new IllegalArgumentException();
        }
        return new SearchCriteria(contributor, title);
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasTitle() {
        return !Validators.isBlank(title);
    }

    public boolean hasContributor() {
        return !Validators.isBlank(contributor);
    }
}
