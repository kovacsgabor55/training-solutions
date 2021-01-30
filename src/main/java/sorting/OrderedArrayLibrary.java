package sorting;

import java.util.Arrays;

public class OrderedArrayLibrary {
    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] sortingById() {
        Book[] sorted = bookArray;
        Arrays.sort(sorted);
        return sorted;
    }

    public Book[] sortingByTitle() {
        Book[] sorted = bookArray;
        Arrays.sort(bookArray, new Book.TitleComparator());
        return sorted;
    }
}
