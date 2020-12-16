package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {
    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();
    public static final long ALTITUDE = 5;

    public long getAltitude() {
        return position.getZ();
    }

    public AstroBoy(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public void liftTo(long altitude) {
        this.position = new Point(position.getX(), position.getY(), altitude);
        this.path.add(position);
    }

    @Override
    public void moveTo(Point position) {
        this.position = position;
        this.path.add(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        liftTo(ALTITUDE);
        this.position = new Point(position.getX(), position.getY(), ALTITUDE);
        this.path.add(this.position);
        moveTo(position);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return this.path;
    }
}
