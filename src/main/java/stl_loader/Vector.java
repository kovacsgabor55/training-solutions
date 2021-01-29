package stl_loader;

import java.io.Serializable;
import java.util.Objects;

public class Vector implements Serializable {
    private final float i;
    private final float j;
    private final float k;

    public Vector(float i, float j, float k) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Float.compare(vector.i, i) == 0 && Float.compare(vector.j, j) == 0 && Float.compare(vector.k, k) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j, k);
    }

    @Override
    public String toString() {
        return "Vector{" + "i=" + i + ", j=" + j + ", k=" + k + '}';
    }
}
