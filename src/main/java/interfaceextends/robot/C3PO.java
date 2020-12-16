package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class C3PO implements MoveableRobot {
    private Point position;
    private int angle;
    private List<Point> path;

    public int getAngle() {
        return angle;
    }

    public Point getPosition() {
        return position;
    }

    public C3PO(Point position) {
        this.path = new ArrayList<>();
        this.position = position;
    }

    @Override
    public void moveTo(Point position) {
        walkTo(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        walkTo(position);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return this.path;
    }

    private void walkTo(Point position) {
        this.position = position;
        path.add(position);
    }
}
