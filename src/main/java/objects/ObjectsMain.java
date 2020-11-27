package objects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {
    public static void main(String[] args) {
        Book[] books = {new Book(), new Book(), new Book()};
        List<Book> books1 = Arrays.asList(new Book(), new Book(), new Book());
        List<Book> books2 = new ArrayList<>();
        books2.add(new Book());
        books2.add(new Book());
        books2.add(new Book());
    }
}
