package activitytracker;

import java.time.LocalDateTime;

public class Activity {
    private final long id;
    private final LocalDateTime startTime;
    private final String desc;
    private final ActivityType type;

    public Activity(long id, LocalDateTime startTime, String desc, ActivityType type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public Activity(LocalDateTime startTime, String desc, ActivityType type) {
        this(0L, startTime, desc, type);
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Activity{" + "id=" + id + ", startTime=" + startTime + ", desc='" + desc + '\'' + ", type=" + type + '}';
    }
}
