package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogParser {
    public Map<String, List<Entry>> parseLog(String log) {
        try {

            Map<String, List<Entry>> ret = new HashMap<>();
            String[] lines = log.split("\n");
            List<Entry> entries = new ArrayList<>();
            for (String item : lines) {
                String[] data = item.split(":");
                if (data.length != 3) {
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }
                entries.add(new Entry(data[0], LocalDate.parse(data[1]), data[2]));
            }
            ret.put(entries.get(0).getIpAddress(), entries);
            return ret;
        } catch (
                DateTimeParseException e) {
            throw new IllegalArgumentException("Incorrect log: incorrect date", e);
        }
    }
}