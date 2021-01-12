package stl_loader;

import java.util.ArrayList;
import java.util.List;

public class Solid {
    private final String name;
    private final List<Facet> facets;

    public Solid(String name) {
        this.name = name;
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
}
