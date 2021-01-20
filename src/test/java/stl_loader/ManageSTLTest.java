package stl_loader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
    void setUp() {

        binarySaved = new File(temporaryFolder, "binarySaved.stl").toPath();
        textSaved = new File(temporaryFolder, "textSaved.stl").toPath();
        standardBinary = Path.of(this.getClass().getResource("/tetrahedronBin.stl").getPath().substring(1));
        standardText = Path.of(this.getClass().getResource("/tetrahedronText.stl").getPath().substring(1));

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
    void saveTextSTLTest() throws IOException {
        assertTrue(saveTextSTL(textSaved, solid));
        byte[] original = this.getClass().getResourceAsStream("/tetrahedronText.stl").readAllBytes();
        byte[] saved = Files.readAllBytes(textSaved);
        assertArrayEquals(original, saved);
    }

    @Test
    @DisplayName("Load solid in text STL file")
    void loadTextSTLTest() {
        assertEquals(solid, loadTextSTL(standardText));
    }

    @Test
    @DisplayName("Save solid to binary STL file")
    void saveBinarySTLTest() throws IOException {
        assertTrue(saveBinarySTL(binarySaved, solid));
        byte[] original = this.getClass().getResourceAsStream("/tetrahedronBin.stl").readAllBytes();
        byte[] saved = Files.readAllBytes(binarySaved);
        assertArrayEquals(original, saved);
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
}