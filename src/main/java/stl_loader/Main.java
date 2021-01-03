package stl_loader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;

//https://stackoverflow.com/questions/18508649/saving-a-binary-stl-file-in-java
//http://www.java2s.com/Code/JavaAPI/java.nio/ByteOrderLITTLEENDIAN.htm
//https://www.programcreek.com/java-api-examples/?class=java.nio.ByteOrder&method=LITTLE_ENDIAN
public class Main {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        System.out.println(toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(toString(bb.array()));

        if (saveSTLbin(Path.of("src/main/resources/out.stl"))) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
    }

    static String toString(byte[] a) {
        StringBuffer result = new StringBuffer("[");
        for (int i = 0; i < a.length; i++) {
            result.append(a[i]);
            if (i < a.length - 1)
                result.append(", ");
        }
        result.append("]");
        return result.toString();
    }

    static boolean saveSTLbin(Path path) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            ByteBuffer bb = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            bb.putInt(12);
            //bb.flip();
            dos.write(new byte[80]);
            dos.write(bb.array());
            //tri1
            put3coord(dos, 0, 0, 0);
            put3coord(dos, -12.7f, -12.7f, 25.4f);//2
            put3coord(dos, 12.7f, -12.7f, 25.4f);//6
            put3coord(dos, -12.7f, 12.7f, 25.4f);//4
            dos.write(new byte[2]);
            //tri2
            put3coord(dos, 0, 0, 0);
            put3coord(dos, -12.7f, 12.7f, 0f);//3
            put3coord(dos, -12.7f, -12.7f, 25.4f);//2
            put3coord(dos, -12.7f, 12.7f, 25.4f);//4
            dos.write(new byte[2]);
            //tri3
            put3coord(dos, 0, 0, 0);
            put3coord(dos, -12.7f, 12.7f, 25.4f);//4
            put3coord(dos, 12.7f, 12.7f, 25.4f);//8
            put3coord(dos, -12.7f, 12.7f, 0f);//3
            dos.write(new byte[2]);
            //tri4
            put3coord(dos, 0, 0, 0);
            put3coord(dos, -12.7f, 12.7f, 0f);//3
            put3coord(dos, 12.7f, 12.7f, 25.4f);//8
            put3coord(dos, 12.7f, 12.7f, 0f);//7
            dos.write(new byte[2]);
            //tri5
            put3coord(dos, 0, 0, 0);
            put3coord(dos, -12.7f, 12.7f, 0f);//3
            put3coord(dos, 12.7f, 12.7f, 0f);//7
            put3coord(dos, -12.7f, -12.7f, 0f);//1
            dos.write(new byte[2]);
            //tri6
            put3coord(dos, 0, 0, 0);
            put3coord(dos, -12.7f, -12.7f, 0f);//1
            put3coord(dos, 12.7f, 12.7f, 0f);//7
            put3coord(dos, 12.7f, -12.7f, 0f);//5
            dos.write(new byte[2]);
            //tri7
            put3coord(dos, 0, 0, 0);
            put3coord(dos, -12.7f, -12.7f, 0f);//1
            put3coord(dos, 12.7f, -12.7f, 0f);//5
            put3coord(dos, -12.7f, -12.7f, 25.4f);//2
            dos.write(new byte[2]);
            //tri8
            put3coord(dos, 0, 0, 0);
            put3coord(dos, 12.7f, 12.7f, 25.4f);//8
            put3coord(dos, 12.7f, -12.7f, 0f);//5
            put3coord(dos, 12.7f, 12.7f, 0f);//7
            dos.write(new byte[2]);
            //tri9
            put3coord(dos, 0, 0, 0);
            put3coord(dos, 12.7f, -12.7f, 25.4f);//6
            put3coord(dos, 12.7f, -12.7f, 0f);//5
            put3coord(dos, 12.7f, 12.7f, 25.4f);//8
            dos.write(new byte[2]);
            //tri10
            put3coord(dos, 0, 0, 0);
            put3coord(dos, -12.7f, -12.7f, 0f);//1
            put3coord(dos, -12.7f, -12.7f, 25.4f);//2
            put3coord(dos, -12.7f, 12.7f, 0f);//3
            dos.write(new byte[2]);
            //tri11
            put3coord(dos, 0, 0, 0);
            put3coord(dos, -12.7f, 12.7f, 25.4f);//4
            put3coord(dos, 12.7f, -12.7f, 25.4f);//6
            put3coord(dos, 12.7f, 12.7f, 25.4f);//8
            dos.write(new byte[2]);
            //tri12
            put3coord(dos, 0, 0, 0);
            put3coord(dos, -12.7f, -12.7f, 25.4f);//2
            put3coord(dos, 12.7f, -12.7f, 0f);//5
            put3coord(dos, 12.7f, -12.7f, 25.4f);//6
            dos.write(new byte[2]);
            //end
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static void put3coord(DataOutputStream dos, float a, float b, float c) throws IOException {
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
}
