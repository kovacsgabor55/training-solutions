package timesheet;

import java.time.LocalDateTime;
import java.util.List;

public class Validator {

    public boolean notSameDay(LocalDateTime date1, LocalDateTime date2) {
        return date1.getDayOfYear() != date2.getDayOfYear();
    }

    public boolean beginDateIsLater(LocalDateTime beginDate, LocalDateTime endDate) {
        return beginDate.isAfter(endDate);
    }

    public boolean notInEmployeesList(List<Employee> employees, String name) {
        for (Employee item : employees) {
            if (item.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}
