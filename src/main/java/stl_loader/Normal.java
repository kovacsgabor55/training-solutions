package stl_loader;

import java.util.Objects;

public class Normal {
    private final float i;
    private final float j;
    private final float k;

    public Normal(float i, float j, float k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public float getI() {
        return i;
    }

    public float getJ() {
        return j;
    }

    public float getK() {
        return k;
    }

    @Override
    public String toString() {
        return "normal " + i + ' ' + j + ' ' + k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Normal normal = (Normal) o;
        return Float.compare(normal.i, i) == 0 && Float.compare(normal.j, j) == 0 && Float.compare(normal.k, k) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j, k);
    }
}
