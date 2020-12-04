package week06d05;

public class Biscuit {
    private BiscuitType type;
    private int gramAmount;

    private Biscuit(BiscuitType type, int gramAmount) {
        this.type = type;
        this.gramAmount = gramAmount;
    }

    public BiscuitType getType() {
        return type;
    }

    public int getGramAmount() {
        return gramAmount;
    }

    public static Biscuit of(BiscuitType type, int gramAmount) {
        if (gramAmount <= 0) {
            throw new IllegalArgumentException("gramAmount canot be Zero or less!");
        }
        return new Biscuit(type, gramAmount);
    }

    @Override
    public String toString() {
        return "Biscuit{" + "type=" + type + ", gramAmount=" + gramAmount + '}';
    }
}
