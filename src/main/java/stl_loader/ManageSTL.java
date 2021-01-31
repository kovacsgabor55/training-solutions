package stl_loader;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public final class ManageSTL {
    private static final String SEARCH_COLOR_STING = "COLOR=";
    private static final String SEARCH_MATERIAL_STING = "MATERIAL=";

    private ManageSTL() {
    }

    /**
     * Egy STL objektumot szöveges fájlba ment.
     *
     * @param path  Az STL fálj mentési helye.
     * @param solid A fájlba mentendő STL objektum.
     * @return Igaz ha sikeres a mentés.
     */
    public static boolean saveTextSTL(@NotNull Path path, @NotNull Solid solid) {
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.US_ASCII)) {
            bw.write("solid " + solid.getName() + "\n");
            List<Facet> facets = solid.getFacets();
            for (Facet item : facets) {
                bw.write(" facet normal " + item.getNormal().getI() + " " + item.getNormal().getJ() + " " + item.getNormal().getK() + "\n  outer loop\n");
                List<Vertex> vertices = item.getVertices();
                for (Vertex vr : vertices) {
                    bw.write("   vertex " + vr.getX() + " " + vr.getY() + " " + vr.getZ() + "\n");
                }
                bw.write("  endloop\n endfacet\n");
            }
            bw.write("endsolid " + solid.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Szöveges fájlboól betölt egy STL modellt.
     *
     * @param path Az STL fájl elérési útvonala.
     * @return A betöltött modell objektum.
     */
    public static Solid loadTextSTL(@NotNull Path path) {
        Solid solid = null;
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
            String str;
            Facet facet = null;
            while ((str = br.readLine()) != null) {
                String[] line = str.strip().split(" ");
                if (line[0].equals("solid")) {
                    solid = new Solid(generateSolidName(line));
                }
                if (line[0].equals("facet") && line[1].equals("normal")) {
                    facet = new Facet();
                    facet.appendNormal(new Vector(Float.parseFloat(line[2]), Float.parseFloat(line[3]), Float.parseFloat(line[4])));
                }
                if (line[0].equals("vertex")) {
                    assert facet != null;
                    facet.appendVertex(new Vertex(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Float.parseFloat(line[3])));
                }
                if (line[0].equals("endfacet")) {
                    assert solid != null;
                    solid.appendFacet(facet);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solid;
    }

    /**
     * Egy STL objektumot bináris fájlba ment.
     *
     * @param path  Az STL fálj mentési helye.
     * @param solid A fájlba mentendő STL objektum.
     * @return Igaz ha sikeres a mentés.
     */
    public static boolean saveBinarySTL(@NotNull Path path, @NotNull Solid solid) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            byte[] head = solid.getName().getBytes(StandardCharsets.US_ASCII);
            dos.write(head);
            if (head.length < 80) {
                dos.write(new byte[80 - head.length]);
            }
            ByteBuffer bb = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            bb.putInt(solid.getFacets().size());
            dos.write(bb.array());
            for (Facet facet : solid.getFacets()) {
                put3Coordinate(dos, facet.getNormal().getI(), facet.getNormal().getJ(), facet.getNormal().getK());
                for (Vertex vertex : facet.getVertices()) {
                    put3Coordinate(dos, vertex.getX(), vertex.getY(), vertex.getZ());
                }
                //color material
                dos.write(new byte[2]);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Bináris fájlból betölt egy STL modellt.
     *
     * @param path Az STL fájl elérési útvonala.
     * @return A betöltött modell objektum.
     */
    public static Solid loadBinarySTL(@NotNull Path path) {
        Solid solid = null;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            byte[] buffer = new byte[4];
            solid = new Solid(headRemoveMaterialsColor(dis.readNBytes(80)));
            dis.read(buffer);
            int numberOfFacet = getIntWithLittleEndian(buffer, 0);
            for (int indexFacet = 0; indexFacet < numberOfFacet; indexFacet++) {
                Facet facet = new Facet();
                dis.read(buffer);
                float a = Float.intBitsToFloat(getIntWithLittleEndian(buffer, 0));
                dis.read(buffer);
                float b = Float.intBitsToFloat(getIntWithLittleEndian(buffer, 0));
                dis.read(buffer);
                float c = Float.intBitsToFloat(getIntWithLittleEndian(buffer, 0));
                facet.appendNormal(new Vector(a, b, c));
                for (int indexVertex = 0; indexVertex < 3; indexVertex++) {
                    dis.read(buffer);
                    float x = Float.intBitsToFloat(getIntWithLittleEndian(buffer, 0));
                    dis.read(buffer);
                    float y = Float.intBitsToFloat(getIntWithLittleEndian(buffer, 0));
                    dis.read(buffer);
                    float z = Float.intBitsToFloat(getIntWithLittleEndian(buffer, 0));
                    facet.appendVertex(new Vertex(x, y, z));
                }
                //colormaterial
                //dis.skip(2);
                matter(dis.readNBytes(2));
                solid.appendFacet(facet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solid;
    }
    //

    private static void matter(byte[] mat) {
        if (mat[0] != 0 && mat[1] != 0) {
            int a = Byte.toUnsignedInt(mat[0]);
            int b = Byte.toUnsignedInt(mat[1]);
            //0123 4567 8901 2345
            //1111 1111 0000 0001
            // System.out.println(a + " " + b);
        } else {
            // System.out.println("emitt");
        }
    }

    private static boolean isColorHeader(byte[] head) {
        return new String(head).contains(SEARCH_COLOR_STING);
    }

    private static boolean isMaterialHeader(byte[] head) {
        return new String(head).contains(SEARCH_MATERIAL_STING);
    }

    private static String headRemoveMaterialsColor(byte[] materializedHead) {
        String tmp = new String(materializedHead);
        if (isColorHeader(materializedHead)) {
            // elokesziti az eltavolitando szin tulajdonsagot
            String remove = tmp.substring(tmp.indexOf(SEARCH_COLOR_STING), tmp.indexOf(SEARCH_COLOR_STING) + SEARCH_COLOR_STING.length() + 4);
            // eltavolitja a szin tulajdonsagot a fejlecbol
            tmp = tmp.replace(remove, "");
        }
        if (isMaterialHeader(materializedHead)) {
            // elokesziti az eltavolitando szin tulajdonsagot
            String remove = tmp.substring(tmp.indexOf(SEARCH_MATERIAL_STING), (tmp.indexOf(SEARCH_MATERIAL_STING) + SEARCH_MATERIAL_STING.length() + 4) * 4);
            // eltavolitja a szin tulajdonsagot a fejlecbol
            tmp = tmp.replace(remove, "");
        }
        return tmp;
    }

    private static RGBAColor headColor(byte[] mat) {
        String tmp = new String(mat);
        RGBAColor rgbaColor = null;
        if (isColorHeader(mat)) {
            int next = (tmp.indexOf(SEARCH_COLOR_STING) + SEARCH_COLOR_STING.length());
            // letrehozza a szint RGBA
            rgbaColor = new RGBAColor(mat[next], mat[next + 1], mat[next + 2], mat[next + 3]);
        }
        return rgbaColor;
    }

    private static Material headMaterial(byte[] mat) {
        String tmp = new String(mat);
        Material material = null;
        if (isMaterialHeader(mat)) {
            int next = (tmp.indexOf(SEARCH_MATERIAL_STING) + SEARCH_MATERIAL_STING.length());
            // letrehozza a szint RGBA
            RGBAColor diffuse = new RGBAColor(mat[next], mat[next + 1], mat[next + 2], mat[next + 3]);
            RGBAColor specular = new RGBAColor(mat[next + 4], mat[next + 5], mat[next + 6], mat[next + 7]);
            RGBAColor ambient = new RGBAColor(mat[next + 8], mat[next + 9], mat[next + 10], mat[next + 11]);
            material = new Material(diffuse, specular, ambient);
        }
        return material;
    }
    //

    /**
     * Egy 4 elemű bájt tömböt little edian szerint alakít egy int számmá.
     *
     * @param bytes  A bemeneti 4 elemű tömb.
     * @param offset eltolás.
     * @return Az átalakított egész szám.
     */
    private static int getIntWithLittleEndian(byte[] bytes, int offset) {
        return (0xff & bytes[offset]) | ((0xff & bytes[offset + 1]) << 8) | ((0xff & bytes[offset + 2]) << 16) | ((0xff & bytes[offset + 3]) << 24);
    }

    /**
     * Beszúr egy három elemű koordinátát mely lehet akár szín vektor vagy pont.
     *
     * @param dos Azon DataOutputStream amibe a koordináta elemeket be kell szúrni.
     * @param a   A koordináta első komponense.
     * @param b   A koordináta második komponense.
     * @param c   A koordináta harmadik komponense.
     * @throws IOException Ha nem sikerül a DataOutputStream-be a beszúrás.
     */
    private static void put3Coordinate(DataOutputStream dos, float a, float b, float c) throws IOException {
        ByteBuffer bb = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        bb.putFloat(a);
        dos.write(bb.array());
        bb = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        bb.putFloat(b);
        dos.write(bb.array());
        bb = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        bb.putFloat(c);
        dos.write(bb.array());
    }

    /**
     * A space karakter mentén szétvágott nevet újra összeilleszti.
     *
     * @param line Azon sor ami tartalmazza a nevet space mentén elválasztva (solid) kezdéssel.
     * @return Az STL modell neve.
     */
    //TODO 80 karakternél nem lehet hosszabb.
    private static String generateSolidName(String[] line) {
        StringBuilder name = new StringBuilder();
        if (line.length >= 2) {
            for (int i = 1; i < line.length; i++) {
                name.append(" ").append(line[i]);
            }
        }
        return name.toString().trim();
    }

    /**
     * Meghatározza, hogy a paraméterében megadott STL fájl text formátumú-e.
     *
     * @param path Az STL fájl elérési útvonala.
     * @return Igaz ha az STL fájl text formátumú.
     */
    private static boolean isTextSTL(Path path) {
        boolean result = false;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            byte[] head = new byte[5];
            dis.read(head);
            result = new String(head, StandardCharsets.US_ASCII).toLowerCase(Locale.ENGLISH).equals("solid");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Fájlból betölt egy STL modellt.
     *
     * @param path Az STL fájl elérési útvonala.
     * @return A betöltött modell objektum.
     */
    public static Solid loadSTL(@NotNull Path path) {
        return isTextSTL(path) ? loadTextSTL(path) : loadBinarySTL(path);
    }
}