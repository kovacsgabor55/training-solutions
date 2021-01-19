package stl_loader;

public class Vector {
    private final float i;
    private final float j;
    private final float k;

    public Vector(float i, float j, float k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public float getI() {
        return i;
    }

    public float getJ() {
        return j;
    }

    public float getK() {
        return k;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "i=" + i +
                ", j=" + j +
                ", k=" + k +
                '}';
    }
}
