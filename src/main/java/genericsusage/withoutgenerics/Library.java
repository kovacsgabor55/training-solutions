package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;
import java.util.Objects;

public class Library {

    public Book getFirstBook(List bookList) {
        Objects.requireNonNull(bookList);
        if (bookList.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        if (bookList.get(0) instanceof Book) {
            return (Book) bookList.get(0);
        }
        throw new ClassCastException("Not a book");
    }
}
