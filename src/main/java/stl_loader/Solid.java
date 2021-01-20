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
            sb.append(item + "\n");
        }
        return "solid " + name.trim() + '\n' +
                sb.toString() +
                "endsolid " + name.trim() + '\n';
    }

    public String info() {
        StringBuilder stringBuilder = new StringBuilder("Solid name: ");
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append("Facets: ");
        stringBuilder.append(facets.size());
        stringBuilder.append("\n");
        stringBuilder.append("Global material: True/False");
        stringBuilder.append("\n");
        stringBuilder.append("Global Colour: True/False");
        stringBuilder.append("\n");
        stringBuilder.append("Local colour: True/False");
        stringBuilder.append("\n");
        return stringBuilder.toString();
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
