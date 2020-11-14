package math;

import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Random rnd = new Random();
        Warrior warrior1 = new Warrior("Joachim", new Point(rnd.nextInt(100), rnd.nextInt(100)));
        Warrior warrior2 = new Warrior("Kahles", new Point(rnd.nextInt(100), rnd.nextInt(100)));

        System.out.println("Let's the hunt begin!");
        for (int i = 1; warrior1.isAlive() && warrior2.isAlive(); i++) {
            System.out.println(i + ". round");
            //w1
            if (warrior1.distance(warrior2) == 0) {
                warrior1.attack(warrior2);
            } else {
                warrior1.move(warrior2.getPosition());
            }
            //w2
            if (warrior2.distance(warrior1) == 0) {
                warrior2.attack(warrior1);
            } else {
                warrior2.move(warrior1.getPosition());
            }
            System.out.println(warrior1);
            System.out.println(warrior2);
        }
        if (warrior1.isAlive()) {
            System.out.println("Winner: " + warrior1);
        } else {
            System.out.println("Winner: " + warrior2);
        }
        System.out.println("Fatility!");
    }
}
