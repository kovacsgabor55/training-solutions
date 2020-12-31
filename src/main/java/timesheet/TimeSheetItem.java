package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeSheetItem {
    private Validator validator;
    private Employee employee;
    private Project project;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    public TimeSheetItem(Validator validator, Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        if (validator.beginDateIsLater(beginDate, endDate) || validator.notSameDay(beginDate, endDate)) {
            throw new IllegalArgumentException();
        }
        this.validator = validator;
        this.employee = employee;
        this.project = project;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Duration countDifferenceBetweenDates() {
        return Duration.ofHours(endDate.getHour() - beginDate.getHour());
    }
}
