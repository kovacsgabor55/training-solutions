package week15d02;

public class QuizItem {
    private String question;
    private int answer;
    private int point;
    private String theme;

    public QuizItem(String question, int answer, int point, String theme) {
        this.question = question;
        this.answer = answer;
        this.point = point;
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public int getPoint() {
        return point;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "QuizItem{" +
                "question='" + question + '\'' +
                ", answer=" + answer +
                ", point=" + point +
                ", theme='" + theme + '\'' +
                '}';
    }
}
