package week03;

public enum Position {
    CEO(150000), MANNAGER(100000);//, CTO, ASSISTANT;
    int bonus;

    Position(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
