package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public int numberOfTrackActivities() {
        int count = 0;
        for (Activity item : activities) {
            if (item instanceof ActivityWithTrack) {
                count++;
            }
        }
        return count;
    }

    public int numberOfWithoutTrackActivities() {
        int count = 0;
        for (Activity item : activities) {
            if (item instanceof ActivityWithoutTrack) {
                count++;
            }
        }
        return count;
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        double sum = 0;
        for (ActivityType type : ActivityType.values()) {
            for (Activity item : activities) {
                if (type == item.getType()) {
                    sum += item.getDistance();
                }
            }
            reports.add(new Report(type, sum));
            sum = 0;
        }
        return reports;
    }
}
