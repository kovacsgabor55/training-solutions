package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        moveTrooper(findTrooperByName(name), target);
    }

    public void moveClosestTrooper(Position target) {
        moveTrooper(findClosestTrooper(target), target);
    }

    private Trooper findTrooperByName(String name) {
        for (Trooper item : troopers) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    private Trooper findClosestTrooper(Position target) {
        Trooper trooper = troopers.get(0);
        for (Trooper item : troopers) {
            if (item.distanceFrom(target) < trooper.distanceFrom(target)) {
                trooper = item;
            }
        }
        return trooper;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }
}
