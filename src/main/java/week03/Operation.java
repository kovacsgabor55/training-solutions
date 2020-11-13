package week03;

public class Operation {
    private int leftValue;
    private int rightValue;

    public Operation(String str) {
        this.leftValue = Integer.parseInt(str.substring(0, str.indexOf("+")));
        this.rightValue = Integer.parseInt(str.substring(str.indexOf("+") + 1));
    }

    public int getResoult() {
        return leftValue + rightValue;
    }
}
