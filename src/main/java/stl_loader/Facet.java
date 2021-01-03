package stl_loader;

import java.util.ArrayList;
import java.util.List;

public class Facet {
    private Normal normal;
    private List<Vertex> vertices;

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
            sb.append(item + "\n");
        }
        return " facet " + normal + "\n  outer loop\n" + sb.toString() + "  endloop";
    }
}
