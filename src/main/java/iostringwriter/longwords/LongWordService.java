package iostringwriter.longwords;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class LongWordService {

    List<String> words;

    public LongWordService() {
        words = new ArrayList<>();
    }

    public String writeWithStringWriter(List<String> words) {
        StringWriter writer = new StringWriter();
        List<String> tmp = new ArrayList<>();
        for (String item : words) {
            tmp.add(item + " " + item.length() + "\n");
        }
        return mockStringWriter(tmp, writer);
    }

    private String mockStringWriter(List<String> words, Writer writer) {
        try (writer) {
            for (String item : words) {
                writer.write(item);
            }
            return writer.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write", ioe);
        }
    }

}
