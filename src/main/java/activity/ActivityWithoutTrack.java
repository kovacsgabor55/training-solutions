package activity;

public class ActivityWithoutTrack {
    private ActivityType activityType;

    public ActivityWithoutTrack(ActivityType activityType) {
        this.activityType = activityType;
    }

    public ActivityType getType() {
        return activityType;
    }
}
