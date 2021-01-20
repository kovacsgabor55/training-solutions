package stl_loader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Facet implements Serializable {
    private Normal normal;
    private final List<Vertex> vertices;

    public Facet() {
        this.vertices = new ArrayList<>();
    }

    public Normal getNormal() {
        return normal;
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    public void appendNormal(Normal normal) {
        this.normal = normal;
    }

    public void appendVertex(Vertex vertex) {
        this.vertices.add(vertex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex item : vertices) {
            sb.append(item).append('\n');
        }
        return " facet " + normal + "\n  outer loop\n" + sb.toString() + "  endloop\n endfacet";
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
}
