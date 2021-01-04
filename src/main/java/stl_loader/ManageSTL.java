package stl_loader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ManageSTL {

    private ManageSTL() {
    }

    public static boolean saveTextSTL(Path path, Solid solid) {
        try (BufferedWriter bw = Files.newBufferedWriter(path, Charset.defaultCharset())) {
            bw.write(solid.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Solid loadTextSTL(Path path) {
        Solid solid = null;
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String str;
            Facet facet = null;
            while ((str = br.readLine()) != null) {
                String[] line = str.strip().split(" ");
                if (line[0].equals("solid")) {
                    solid = new Solid(generateSolidName(line));
                }
                if (line[0].equals("facet") && line[1].equals("normal")) {
                    facet = new Facet();
                    facet.appendNormal(new Normal(Float.parseFloat(line[2]), Float.parseFloat(line[3]), Float.parseFloat(line[4])));
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

    public static boolean saveBinarySTL(Path path, Solid solid) {
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
                dos.write(new byte[2]);
            }
            dos.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Solid loadBinarySTL(Path path) {
        Solid solid = null;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            byte[] buffer = new byte[4];
            solid = new Solid(new String(dis.readNBytes(80)));
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
                facet.appendNormal(new Normal(a, b, c));
                for (int indexVertex = 0; indexVertex < 3; indexVertex++) {
                    dis.read(buffer);
                    float x = Float.intBitsToFloat(getIntWithLittleEndian(buffer, 0));
                    dis.read(buffer);
                    float y = Float.intBitsToFloat(getIntWithLittleEndian(buffer, 0));
                    dis.read(buffer);
                    float z = Float.intBitsToFloat(getIntWithLittleEndian(buffer, 0));
                    facet.appendVertex(new Vertex(x, y, z));
                }
                dis.skip(2);
                byte[] skip = dis.readNBytes(2);
                solid.appendFacet(facet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solid;
    }

    private static int getIntWithLittleEndian(byte[] bytes, int offset) {
        return (0xff & bytes[offset]) | ((0xff & bytes[offset + 1]) << 8) | ((0xff & bytes[offset + 2]) << 16) | ((0xff & bytes[offset + 3]) << 24);
    }

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

    private static String generateSolidName(String[] line) {
        StringBuilder name = new StringBuilder();
        if (line.length >= 2) {
            for (int i = 1; i < line.length; i++) {
                name.append(" " + line[i]);
            }
        }
        return name.toString().trim();
    }
}