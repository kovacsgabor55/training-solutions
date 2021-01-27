package filescanner.library;

public class Book {
    private String author;
    private String title;
    private String registrationNumber;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(String author, String title, String registartionNumber) {
        this.registrationNumber = registartionNumber;
        this.author = author;
        this.title = title;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}