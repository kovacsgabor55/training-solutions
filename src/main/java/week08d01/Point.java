package week08d01;

public final class Point {
    private int x;
    private int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point step(Point point) {
        return new Point(x + point.x, y + point.y);
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
