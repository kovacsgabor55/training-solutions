package methodchain.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int distance;
    private int azimut;
    private List<NavigationPoint> navigationPoints;

    public Robot() {
        navigationPoints = new ArrayList<>();
    }

    public Robot go(int meter) {
        this.distance += meter;
        return this;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getAzimut() {
        return this.azimut;
    }

    public Robot rotate(int angle) {
        this.azimut += angle;
        return this;
    }

    public Robot registerNavigationPoint() {
        navigationPoints.add(new NavigationPoint(this.distance, this.azimut));
        return this;
    }

    public String getNavigationList() {
        return navigationPoints.toString();
    }
}
