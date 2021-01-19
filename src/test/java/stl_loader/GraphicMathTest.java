package stl_loader;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;
import static stl_loader.GraphicMath.*;

class GraphicMathTest {
    Vertex v1, v2, v3, v4, v5, v6, v7, v8;
    Normal nn001, nn010, nn100, ni001, ni010, ni100;

    @BeforeEach
    void setUp() {
        v7 = new Vertex(-12.7f, -12.7f, 0.0f);
        v1 = new Vertex(-12.7f, -12.7f, 25.4f);
        v4 = new Vertex(-12.7f, 12.7f, 0.0f);
        v3 = new Vertex(-12.7f, 12.7f, 25.4f);
        v8 = new Vertex(12.7f, -12.7f, 0.0f);
        v2 = new Vertex(12.7f, -12.7f, 25.4f);
        v6 = new Vertex(12.7f, 12.7f, 0.0f);
        v5 = new Vertex(12.7f, 12.7f, 25.4f);
        ni100 = new Normal(-1.0f, 0.0f, 0.0f);
        ni010 = new Normal(0.0f, -1.0f, 0.0f);
        ni001 = new Normal(0.0f, 0.0f, -1.0f);
        nn001 = new Normal(0.0f, 0.0f, 1.0f);
        nn010 = new Normal(0.0f, 1.0f, 0.0f);
        nn100 = new Normal(1.0f, 0.0f, 0.0f);
    }

    @Test
    @DisplayName("One normalized vector calculator")
    void calculateNormalVectorTest() {
        assertEquals(nn001, calculateNormalVector(v1, v2, v3));
        assertEquals(ni100, calculateNormalVector(v4, v1, v3));
        assertEquals(nn010, calculateNormalVector(v3, v5, v4));
        assertEquals(nn010, calculateNormalVector(v4, v5, v6));
        assertEquals(ni001, calculateNormalVector(v4, v6, v7));
        assertEquals(ni001, calculateNormalVector(v7, v6, v8));
        assertEquals(ni010, calculateNormalVector(v7, v8, v1));
        assertEquals(nn100, calculateNormalVector(v5, v8, v6));
        assertEquals(nn100, calculateNormalVector(v2, v8, v5));
        assertEquals(ni100, calculateNormalVector(v7, v1, v4));
        assertEquals(nn001, calculateNormalVector(v3, v2, v5));
        assertEquals(ni010, calculateNormalVector(v1, v8, v2));
    }

    @Test
    void chckTest() throws IOException, NoSuchAlgorithmException {
        //Create checksum for this file
        File file = new File("src/main/resources/cubeText.stl");

//Use MD5 algorithm
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");

//Get the checksum
        String checksum = getFileChecksum(md5Digest, file);

//see checksum


        //Use SHA-1 algorithm
        MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");

//SHA-1 checksum
        String shaChecksum = getFileChecksum(shaDigest, file);
        System.out.println(checksum);
        assertEquals(checksum, getFileChecksum(md5Digest, new File("src/main/resources/outCubeBin.stl")));
    }


    private static String getFileChecksum(MessageDigest digest, File file) throws IOException {
        //Get file input stream for reading the file content
        FileInputStream fis = new FileInputStream(file);

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        //Read file data and update in message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        }

        //close the stream; We don't need it now.
        fis.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }
}