package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {
    private List<Object> items = new ArrayList<>();
    private int cursor = -1;

    public SimpleBag() {
    }

    public void putItem(Object item) {
        this.items.add(item);
    }

    public boolean isEmpty() {
        return (items.isEmpty());
    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursor = -1;
    }

    public boolean hasNext() {
        return !(isEmpty() || cursor >= items.size() - 1);
    }

    public Object next() {
        cursor++;
        return items.get(cursor);
    }

    public boolean contains(Object item) {
        return this.items.contains(item);
    }

    public int getCursor() {
        return this.cursor;
    }
}
