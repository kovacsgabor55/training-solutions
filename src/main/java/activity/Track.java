package activity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public void loadFromGpx(InputStream is) {
    }

    public double getFullElevation() {
        double sum = 0;
        double actual = trackPoints.get(0).getElevation();
        for (TrackPoint item : trackPoints) {
            if (actual < item.getElevation()) {
                sum += item.getElevation() - actual;
            }
            actual = item.getElevation();
        }
        return sum;
    }

    public double getFullDecrease() {
        double sum = 0;
        double actual = trackPoints.get(0).getElevation();
        for (TrackPoint item : trackPoints) {
            if (actual > item.getElevation()) {
                sum += actual - item.getElevation();
            }
            actual = item.getElevation();
        }
        return sum;
    }

    public double getDistance() {
        double sum = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            sum += trackPoints.get(i - 1).getDistanceFrom(trackPoints.get(i));
        }
        return sum;
    }

    public Coordinate findMinimumCoordinate() {
        double minLat = trackPoints.get(0).getCoordinate().getLatitude();
        double minLon = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLatitude() < minLat) {
                minLat = item.getCoordinate().getLatitude();
            }
            if (item.getCoordinate().getLongitude() < minLon) {
                minLon = item.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLat, minLon);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLat = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLon = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLatitude() > maxLat) {
                maxLat = item.getCoordinate().getLatitude();
            }
            if (item.getCoordinate().getLongitude() > maxLon) {
                maxLon = item.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLat, maxLon);
    }

    public double getRectangleArea() {
        return 0;
    }
}
