package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {
    List<SimpleTime> timeTable;

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        timeTable = new ArrayList<>();
        for (int hour = firstHour; hour <= lastHour; hour++) {
            timeTable.add(new SimpleTime(hour, everyMinute));
        }
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        for (SimpleTime item : timeTable) {
            if (item.difference(actual) > 0) {
                return item;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }
}
