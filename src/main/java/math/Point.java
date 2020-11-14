package math;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point other) {
        int x = Math.abs(this.x - other.x);
        int y = Math.abs(this.y - other.y);
        return (x > y) ? x : y;
    }
}
