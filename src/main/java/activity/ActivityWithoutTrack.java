package activity;

public class ActivityWithoutTrack implements Activity {
    private ActivityType activityType;

    public ActivityWithoutTrack(ActivityType activityType) {
        this.activityType = activityType;
    }

    public ActivityType getType() {
        return activityType;
    }

    public double getDistance() {
        return 0;
    }
}
