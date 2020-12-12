package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character {
    public AxeWarrior(Point position, Random random) {
        super(position, random);
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if (getPosition().distance(enemy.getPosition()) < 2) {
            hit(enemy, getActualSecondaryDamage());
        }
    }

    private int getActualSecondaryDamage() {
        return getActualPrimaryDamage() * 2;
    }
}
