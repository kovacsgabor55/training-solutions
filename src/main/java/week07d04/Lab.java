package week07d04;

import java.time.LocalDate;

public class Lab {
    private String title;
    private boolean completed;
    private LocalDate completedAt;

    public Lab(String title) {
        this.title = title;
        this.completed = false;
        this.completedAt = null;
    }

    public Lab(String title, LocalDate completedAt) {
        this.title = title;
        this.completed = true;
        this.completedAt = completedAt;
    }

    public void complete(LocalDate localDate) {
        this.completed = true;
        this.completedAt = localDate;
    }

    public void complete() {
        complete(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Lab{" + "title='" + title + '\'' + ", completed=" + completed + ", completedAt=" + completedAt + '}';
    }
}
