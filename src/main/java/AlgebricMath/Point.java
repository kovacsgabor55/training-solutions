package AlgebricMath;

import java.util.List;
import java.util.Objects;

public class Point {
    private List<Number> elements;

    public Point(List<Number> elements) {
        this.elements = elements;
    }

    public List<Number> getElements() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(elements, point.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
