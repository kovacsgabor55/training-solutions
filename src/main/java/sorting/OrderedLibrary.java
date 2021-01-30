package sorting;

import java.util.Collections;
import java.util.Set;

public class OrderedLibrary {
    private Set<Book> library;

    public OrderedLibrary(Set<Book> library) {
        if (library.isEmpty()) {
            throw new NullPointerException("Libray is empty!");
        }
        this.library = library;
    }

    public Book lendFirstBook() {
        return Collections.min(library);
    }
}
