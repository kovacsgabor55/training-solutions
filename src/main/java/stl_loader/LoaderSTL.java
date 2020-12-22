package stl_loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public final class LoaderSTL {
    private LoaderSTL() {
    }

    static Solid loadSTLtxt(Path path) {
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

    static Solid loadSTLbin(Path path) {
        Solid solid = null;
        try (InputStream is = Files.newInputStream(path)) {

            String str = new String(is.readNBytes(80));
            System.out.println(str);
            byte[] nroftrianglesbin = is.readNBytes(4);
            StringBuilder sb = new StringBuilder();
            for (int i = 3; i >= 0; i--) {
                sb.append(String.format("%8s", Integer.toBinaryString(nroftrianglesbin[i] & 0xFF)).replace(' ', '0'));
            }
            int decimal = Integer.parseInt(sb.toString(), 2);
            for (int i = 0; i <= decimal; i++) {
                byte[] datein = is.readNBytes(50);
            }
            System.out.println(decimal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solid;
    }

    public static void main(String[] args) {
        //System.out.println(loadSTLtxt(Path.of("src/main/resources/Sphericon.stl")));
        System.out.println(loadSTLbin(Path.of("src/main/resources/Utah_teapot_(solid).stl")));
    }

}
