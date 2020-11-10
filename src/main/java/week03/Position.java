package week03;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Position{" + "name='" + name + '\'' + ", bonus=" + bonus + '}';
    }

    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position("első", 1541));
        positions.add(new Position("második", 154141));
        positions.add(new Position("harmadik", 11));
        positions.add(new Position("negyedik", 16572));
        positions.add(new Position("ötödik", 165842));


        for (Position item : positions) {
            if (item.getBonus() > 150000) {
                System.out.println(item.getBonus());
            }
        }
    }
}
