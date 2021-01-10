package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            double latitude = 0;
            double longitude = 0;
            double elevation = 0;
            boolean coordinateReady = false;
            boolean elevationReady = false;
            while ((line = br.readLine()) != null) {
                if (line.trim().startsWith("<trkpt")) {
                    line = line.replace("<trkpt lat=\"", "").replace("\" lon=\"", " ").replace("\">", "").trim();
                    String[] coordinateData = line.split(" ");
                    latitude = Double.parseDouble(coordinateData[0]);
                    longitude = Double.parseDouble(coordinateData[1]);
                    coordinateReady = true;
                }
                if (line.trim().startsWith("<ele>")) {
                    line = line.replace("<ele>", "").replace("</ele>", "").trim();
                    elevation = Double.parseDouble(line);
                    elevationReady = true;
                }
                if (coordinateReady && elevationReady) {
                    trackPoints.add(new TrackPoint(new Coordinate(latitude, longitude), elevation));
                    coordinateReady = false;
                    elevationReady = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        double minLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double minLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLatitude() < minLatitude) {
                minLatitude = item.getCoordinate().getLatitude();
            }
            if (item.getCoordinate().getLongitude() < minLongitude) {
                minLongitude = item.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLatitude, minLongitude);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLatitude() > maxLatitude) {
                maxLatitude = item.getCoordinate().getLatitude();
            }
            if (item.getCoordinate().getLongitude() > maxLongitude) {
                maxLongitude = item.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLatitude, maxLongitude);
    }

    public double getRectangleArea() {
        Coordinate min = findMinimumCoordinate();
        Coordinate max = findMaximumCoordinate();
        return ((max.getLatitude() - min.getLatitude()) * (max.getLongitude() - min.getLongitude()));
    }
}
