package collectionscomp;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class OrderedLibrary {
    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {
        Collections.sort(libraryBooks);
        return libraryBooks;
    }

    public List<Book> orderedByAuthor() {
        Collections.sort(libraryBooks, new Book.NameComparator());
        return libraryBooks;
    }

    //csolvkerg
    public List<String> orderedByTitleLocale(Locale locale) {

        List<String> orderedList = new ArrayList<>();
        for (Book book : libraryBooks) {
            orderedList.add(book.getTitle());
        }

        Collator hungarianCollator = Collator.getInstance(locale);
        hungarianCollator.setStrength(Collator.PRIMARY);
        Collections.sort(orderedList, hungarianCollator);

        return orderedList;
    }
}
