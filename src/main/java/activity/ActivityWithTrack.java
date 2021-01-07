package activity;

public class ActivityWithTrack {
    private ActivityType activityType;
    private Track track;

    public ActivityWithTrack(Track track, ActivityType activityType) {
        this.track = track;
        this.activityType = activityType;
    }

    public ActivityType getType() {
        return activityType;
    }
}
