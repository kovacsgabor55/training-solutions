package stl_loader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solid implements Serializable {
    private final String name;
    private final List<Facet> facets;

    public Solid(String name) {
        this.name = name.trim();
        this.facets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Facet> getFacets() {
        return new ArrayList<>(facets);
    }

    public void appendFacet(Facet facet) {
        facets.add(facet);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Facet item : facets) {
            sb.append(item).append('\n');
        }
        return "solid " + name + '\n' +
                sb.toString() +
                "endsolid " + name + '\n';
    }

    public String info() {
        return "Solid name: " + name +
                "\nFacets: " + facets.size() +
                "\nGlobal material: True/False" +
                "\nGlobal colour: True/False" +
                "\nLocal colour: True/False" +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solid solid = (Solid) o;
        return Objects.equals(name, solid.name) && Objects.equals(facets, solid.facets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, facets);
    }
}
