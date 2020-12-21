package stl_loader;

import java.util.ArrayList;
import java.util.List;

public class Solid {
    private String name;
    private List<Facet> facets;

    public Solid(String name) {
        this.name = name;
        this.facets = new ArrayList<>();
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
        return "Solid " + name + '\n' +
                sb.toString() +
                " endfacet\nendsolid " + name + '\n';
    }
}
