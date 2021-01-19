package iofilestest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void add(Book books) {
        this.books.add(books);
    }

    public void saveBooks(Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Book item : books) {
                writer.write(item.getAuthor() + ";" + item.getTitle() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBooks(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String author = line.split(";")[0];
                String title = line.split(";")[1];
                books.add(new Book(author, title));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
