package stl_loader;

public class Vertex {
    private float x;
    private float y;
    private float z;

    public Vertex(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "   vertex " + x + ' ' + y + ' ' + z;
    }
}
