package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {
    Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        Book result = null;
        for (Iterator<Book> item = libraryBooks.iterator(); item.hasNext(); ) {
            Book tmp = item.next();
            if (tmp.getRegNumber() == regNumber) {
                result = tmp;
            }
        }
        if (result == null) {
            throw new MissingBookException("No books found with regnumber: " + regNumber);
        }
        return result;
    }

    public int removeBookByRegNumber(int regNumber) {
        Book result = null;
        for (Iterator<Book> item = libraryBooks.iterator(); item.hasNext(); ) {
            Book tmp = item.next();
            if (tmp.getRegNumber() == regNumber) {
                result = tmp;
            }
        }
        if (libraryBooks.remove(result)) {
            return regNumber;
        } else {
            throw new MissingBookException("No books found with regnumber: " + regNumber);
        }
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> result = new HashSet<>();
        for (Iterator<Book> item = libraryBooks.iterator(); item.hasNext(); ) {
            Book tmp = item.next();
            if (tmp.getAuthor().equals(author)) {
                result.add(tmp);
            }
        }
        if (result.isEmpty()) {
            throw new MissingBookException("No books found by Tolkien");
        }
        return result;
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }
}
