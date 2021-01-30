package sorting;

import java.util.Comparator;

public class Book implements Comparable<Book> {
    private int id;
    private String author;
    private String title;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.id, o.id);
    }

    public static class TitleComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            return o1.title.compareTo(o2.title);
        }
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
