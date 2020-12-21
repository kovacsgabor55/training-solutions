package stl_loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public final class LoaderSTLtxt {
    private LoaderSTLtxt() {
    }

    static Solid loadSTL(Path path) {
        Solid solid = null;
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String str;
            Facet facet = null;
            while ((str = br.readLine()) != null) {
                String[] line = str.strip().split(" ");
                if (line[0].equals("solid")) {
                    solid = new Solid(line[1]);
                }
                if (line[0].equals("facet") && line[1].equals("normal")) {
                    facet = new Facet();
                    facet.appendNormal(new Normal(Float.parseFloat(line[2]), Float.parseFloat(line[3]), Float.parseFloat(line[4])));
                }
                if (line[0].equals("vertex")) {
                    facet.appendVertex(new Vertex(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Float.parseFloat(line[3])));
                }
                if (line[0].equals("endfacet")) {
                    solid.appendFacet(facet);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solid;
    }

    public static void main(String[] args) {
        System.out.println(loadSTL(Path.of("src/main/resources/Sphericon.stl")));
    }
}
