package stl_loader;

import java.io.Serializable;
import java.util.*;

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

    @Override
    public String toString() {
        return "Solid{" + "name='" + name + '\'' + ", facets=" + facets + '}';
    }
}
