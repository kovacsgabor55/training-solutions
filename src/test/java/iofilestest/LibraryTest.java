package iofilestest;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Book b1, b2;
    Library library=new Library();

    @Rule
    TemporaryFolder temporaryFolder = new TemporaryFolder();

    @BeforeEach
    void setUp() {
        b1 = new Book("autt hor", "tit lee");
        b2 = new Book("kedekadocs", "vevencever");
    }

    @Test
    void saveBooks() throws IOException {
        library.add(b1);
        library.add(b2);
       /* Path file = temporaryFolder.newFile("teszt.txt").toPath();
        System.out.println(file);*/
    }

    @Test
    void loadBooks() {
    }
}