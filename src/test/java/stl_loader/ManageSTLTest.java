package stl_loader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;
import static stl_loader.ManageSTL.*;

class ManageSTLTest {
    Vertex v1, v2, v3, v4;
    Normal n1, n2, n3, n4;
    Facet f1, f2, f3, f4;
    Solid solid;
    String name;
    Path binarySaved, textSaved, standardBinary, standardText;

    @TempDir
    public File temporaryFolder;

    @BeforeEach
    void setUp() throws URISyntaxException {
       Path aa= Path.of(ManageSTLTest.class.getResource("/tetrahedronBin.stl").toString());
        System.out.println(aa.toString());
        binarySaved = Path.of("src", "test", "resources", "binarySaved.stl");
        textSaved = Path.of("src", "test", "resources", "textSaved.stl");
        standardBinary = Path.of("src", "test", "resources", "tetrahedronBin.stl");
        standardText = Path.of("src", "test", "resources", "tetrahedronText.stl");

        name = "Tetrahedron";
        solid = new Solid(name);
        v1 = new Vertex(-21.42956f, -24.743374f, 2.1854011E-4f);
        v2 = new Vertex(-21.424925f, 24.743374f, 4.499738E-4f);
        v3 = new Vertex(21.42956f, -0.00405644f, 0.0f);
        v4 = new Vertex(-7.1412497f, -0.0014983413f, 40.00018f);

        f1 = new Facet();
        f2 = new Facet();
        f3 = new Facet();
        f4 = new Facet();

        n1 = new Normal(-7.798948E-6f, 4.677411E-6f, -1.0f);
        n2 = new Normal(0.4707968f, -0.81561923f, 0.33632675f);
        n3 = new Normal(0.47095105f, 0.8155276f, 0.3363327f);
        n4 = new Normal(-0.94173944f, 8.6628985E-5f, 0.33634335f);

        f1.appendVertex(v1);
        f1.appendVertex(v2);
        f1.appendVertex(v3);

        f2.appendVertex(v1);
        f2.appendVertex(v3);
        f2.appendVertex(v4);

        f3.appendVertex(v2);
        f3.appendVertex(v4);
        f3.appendVertex(v3);

        f4.appendVertex(v1);
        f4.appendVertex(v4);
        f4.appendVertex(v2);

        f1.appendNormal(n1);
        f2.appendNormal(n2);
        f3.appendNormal(n3);
        f4.appendNormal(n4);

        solid.appendFacet(f1);
        solid.appendFacet(f2);
        solid.appendFacet(f3);
        solid.appendFacet(f4);
    }

    @Test
    @DisplayName("Save solid to text STL file")
    void saveTextSTLTest() throws IOException, NoSuchAlgorithmException {
        saveTextSTL(textSaved, solid);
        assertEquals(checkSumMD5(new File(textSaved.toUri())), checkSumMD5(new File(standardText.toUri())));
        assertEquals(checkSumSHA1(new File(textSaved.toUri())), checkSumSHA1(new File(standardText.toUri())));
    }

    @Test
    @DisplayName("Load solid in text STL file")
    void loadTextSTLTest() {
        assertEquals(solid, loadTextSTL(standardText));
    }

    @Test
    @DisplayName("Save solid to binary STL file")
    void saveBinarySTLTest() throws IOException, NoSuchAlgorithmException {
        saveBinarySTL(binarySaved, solid);
        assertEquals(checkSumMD5(new File(binarySaved.toUri())), checkSumMD5(new File(standardBinary.toUri())));
        assertEquals(checkSumSHA1(new File(binarySaved.toUri())), checkSumSHA1(new File(standardBinary.toUri())));
    }

    @Test
    @DisplayName("Load solid in binary STL file")
    void loadBinarySTLTest() {
        assertEquals(solid, loadBinarySTL(standardBinary));
    }

    @Test
    @DisplayName("Load solid in non specified STL file")
    void loadSTLTest() {
        assertEquals(solid, loadSTL(standardText));
        assertEquals(solid, loadSTL(standardBinary));
    }


    private static String checkSumMD5(File file) throws IOException, NoSuchAlgorithmException {
        //Use MD5 algorithm
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");

        //Get the checksum
        return getFileChecksum(md5Digest, file);
    }

    private static String checkSumSHA1(File file) throws IOException, NoSuchAlgorithmException {
        //Use SHA-1 algorithm
        MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");

        //SHA-1 checksum
        return getFileChecksum(shaDigest, file);
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
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }
}