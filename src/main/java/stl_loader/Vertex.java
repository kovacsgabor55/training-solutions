package stl_loader;

import java.io.Serializable;
import java.util.Objects;

public class Vertex implements Serializable {
    private final float x;
    private final float y;
    private final float z;

    public Vertex(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Float.compare(vertex.x, x) == 0 && Float.compare(vertex.y, y) == 0 && Float.compare(vertex.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Vertex{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
