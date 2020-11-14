package arrays;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private ArrayList<String> titles = new ArrayList<>();

    public void add(String title) {
        titles.add(title);
    }

    public List<String> findAllByPrefix(String prefix) {
        ArrayList<String> returns = new ArrayList<>();
        for (String item : titles) {
            if (item.indexOf(prefix) == 0) {
                returns.add(item);
            }
        }
        return returns;
    }

    public List<String> getTitles() {
        return titles;
    }

    public static void main(String[] args) {
        Books books = new Books();
        books.add("aabbcc");
        books.add("ddeeffgg");
        books.add("gghhii");
        books.add("jjkkll");
        books.add("gghfgdfgd");
        List<String> test = new ArrayList<>();
        test = books.findAllByPrefix("gg");
        for (String item : test) {
            System.out.println(item);
        }
        System.out.println();
        test = books.getTitles();
        for (String item : test) {
            System.out.println(item);
        }
    }
}
