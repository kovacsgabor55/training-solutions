package week08d04;

public class Main {
    public static void main(String[] args) {
        Trainer trainerHappy = new Trainer(new GoodMood());
        System.out.println(trainerHappy.giveMark());
        Trainer trainerSad = new Trainer(new BadMood());
        System.out.println(trainerSad.giveMark());
    }
}
