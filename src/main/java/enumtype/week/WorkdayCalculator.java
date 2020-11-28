package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {
    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> ret = new ArrayList<>();
        for (int i = 0; i < numberOfDays; i++) {
            ret.add(firstDay.getDayType());
            firstDay = nextDay(firstDay);
        }
        return ret;
    }

    private Day nextDay(Day day) {
        if (day.ordinal() == Day.values().length - 1) {
            return Day.values()[0];
        } else {
            return Day.values()[day.ordinal() + 1];
        }
    }
}
