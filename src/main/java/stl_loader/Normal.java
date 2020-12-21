package stl_loader;

public class Normal {
    private float i;
    private float j;
    private float k;

    public Normal(float i, float j, float k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    @Override
    public String toString() {
        return "normal " + i + ' ' + j + ' ' + k;
    }
}
