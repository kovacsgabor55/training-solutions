package math;

import java.util.Random;

public class Warrior {
    private String name;
    private int stamina;
    private double skill;
    private Point position;
    Random rnd = new Random();

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        this.skill = rnd.nextDouble();
        this.stamina = rnd.nextInt(80) + 20;

    }

    public Point getPosition() {
        return position;
    }

    public void move(Point position) {
        int x = this.position.getX();
        int y = this.position.getY();

        if (x < position.getX()) {
            x += 1;
        } else if (x > position.getX()) {
            x -= 1;
        }

        if (y < position.getY()) {
            y += 1;
        } else if (y > position.getY()) {
            y -= 1;
        }
        this.position = new Point(x, y);
    }

    public void attack(Warrior warrior) {
        if (rnd.nextDouble() < this.skill) {
            warrior.stamina -= rnd.nextInt(2) + 1;
            if (warrior.stamina < 0) {
                warrior.stamina = 0;
            }
        }
    }

    public double distance(Warrior warrior) {
        return this.position.distance(warrior.position);
    }

    public boolean isAlive() {
        return (stamina > 0);
    }

    @Override
    public String toString() {
        return name + ": (" + position.getX() + "," + position.getY() + ") " + stamina;
    }
}
