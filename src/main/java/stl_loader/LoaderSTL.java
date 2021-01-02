package stl_loader;

import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
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
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {

            String str = new String(dis.readNBytes(80));
            System.out.println(str);
            int decimal = readReverseInt(dis);

                    //     1234567812345678123456781234567812345678123456781234567812345678
            String text = "00110011001100110100101111000001";
            System.out.println(Double.longBitsToDouble(Integer.parseInt(text,2)));
            System.out.println(Double.longBitsToDouble(new BigInteger(text, 2).longValue()));
            //double doubleVal = Double.longBitsToDouble(new BigInteger(text, 2).longValue());

            System.out.println("itt");
            System.out.println(Double.doubleToLongBits(12.5));
            long ha = Double.doubleToLongBits(12.5);
            String bin = Long.toBinaryString(ha);
            System.out.println(bin);
            System.out.println(Double.longBitsToDouble(new BigInteger(bin, 2).longValue()));
            System.out.println("itt");
            //System.out.println(doubleVal);


            for (int i = 0; i < 12; i++) {
                 System.out.println(readReverseDouble(dis));
            }
            /*for (int i = 0; i <= decimal; i++) {
                byte[] datein = dis.readNBytes(50);
            }*/
            System.out.println(decimal);
            //9438
            System.out.println(decimal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solid;
    }

    public static void main(String[] args) {
        //System.out.println(loadSTLtxt(Path.of("src/main/resources/Sphericon.stl")));
        System.out.println(loadSTLbin(Path.of("src/main/resources/teszt.stl")));
    }

    private static double readReverseDouble(DataInputStream dis) throws IOException {
        byte[] nroftrianglesbin = dis.readNBytes(4);
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            sb.append(String.format("%8s", Integer.toBinaryString(nroftrianglesbin[i] & 0xFF)).replace(' ', '0'));
        }
        return Double.longBitsToDouble(new BigInteger(sb.toString(), 2).longValue());
    }

    private static int readReverseInt(DataInputStream dis) throws IOException {
        byte[] nroftrianglesbin = dis.readNBytes(4);
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            sb.append(String.format("%8s", Integer.toBinaryString(nroftrianglesbin[i] & 0xFF)).replace(' ', '0'));
        }
        return Integer.parseInt(sb.toString(), 2);
    }

   /* private static double readReverseDouble(DataInputStream dis) throws IOException{
        byte[] nroftrianglesbin = dis.readNBytes(4);
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            sb.append(String.format("%8s", Integer.toBinaryString(nroftrianglesbin[i] & 0xFF)).replace(' ', '0'));
        }
        return Double.parseDouble(sb.toString(), 2);
    }
    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }*/
}
