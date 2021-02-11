package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {
    private List<QuizItem> quizItems = new ArrayList<>();

    public void loadFile(String fileName) {
        Path path = Path.of(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String name;
            while ((name = br.readLine()) != null) {
                parse(name, br.readLine());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file", e);
        }
    }

    private void parse(String name, String line) {
        String[] lineArray = line.split(" ");
        quizItems.add(new QuizItem(name, Integer.parseInt(lineArray[0]), Integer.parseInt(lineArray[1]), lineArray[2]));
    }

    public Map<String, List<QuizItem>> sortTheme() {
        Map<String, List<QuizItem>> result = new HashMap<>();
        for (QuizItem item : quizItems) {
            if (!result.containsKey(item.getTheme())) {
                result.put(item.getTheme(), new ArrayList<>());
            }
            result.get(item.getTheme()).add(item);
        }
        return result;
    }

    public String maxPointTheme() {
        Map<String, List<QuizItem>> work = sortTheme();
        int max = 0;
        String result = null;
        for (String key : work.keySet()) {
            int sum = 0;
            for (QuizItem item : work.get(key)) {
                sum += item.getPoint();
            }
            if (max < sum) {
                max = sum;
                result = key;
            }
        }
        return result;
    }

    public List<String> getThemeQuestion(String theme) {
        Map<String, List<QuizItem>> temp = sortTheme();
        List<String> result = new ArrayList<>();
        for (QuizItem item : temp.get(theme)) {
            result.add(item.getQuestion());
        }
        return result;
    }

    public QuizItem randomQuestion() {
        List<QuizItem> rand = new ArrayList<>(quizItems);
        Collections.shuffle(rand);
        return rand.get(0);
    }

    public List<QuizItem> getQuizItems() {
        return new ArrayList<>(quizItems);
    }


    public static void main(String[] args) {
        Quiz q = new Quiz();
        q.loadFile("src/main/resources/kerdesek.txt");
        System.out.println(q.quizItems.size());
        System.out.println(q.sortTheme());
        System.out.println(q.randomQuestion());
        System.out.println(q.randomQuestion());
        System.out.println(q.randomQuestion());
        System.out.println(q.randomQuestion());
        System.out.println(q.getThemeQuestion("magyar"));
        System.out.println(q.getThemeQuestion("matematika"));
    }
}
