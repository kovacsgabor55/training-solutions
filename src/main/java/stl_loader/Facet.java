package stl_loader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Facet implements Serializable {
    private Vector normal;
    private final List<Vertex> vertices;

    public Facet() {
        this.vertices = new ArrayList<>();
    }

    public Vector getNormal() {
        return normal;
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    public void appendNormal(Vector normal) {
        this.normal = normal;
    }

    public void appendVertex(Vertex vertex) {
        this.vertices.add(vertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facet facet = (Facet) o;
        return Objects.equals(normal, facet.normal) && Objects.equals(vertices, facet.vertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(normal, vertices);
    }

    @Override
    public String toString() {
        return "Facet{" + "normal=" + normal + ", vertices=" + vertices + '}';
    }
}
