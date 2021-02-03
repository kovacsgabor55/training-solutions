package stl_loader;

import org.jetbrains.annotations.NotNull;

public class GraphicMath {
    private GraphicMath() {
    }

    public static Vector calculateNormalVector(@NotNull Vertex v1, @NotNull Vertex v2, @NotNull Vertex v3) {
        Vector v = pointsToVector(v2, v1);
        Vector w = pointsToVector(v3, v1);
        Vector d = dotProduct(v, w);
        return normalizeVector(d);
    }

    public static Vector pointsToVector(@NotNull Vertex v1, @NotNull Vertex v2) {
        float i = v2.getX() - v1.getX();
        float j = v2.getY() - v1.getY();
        float k = v2.getZ() - v1.getZ();
        return new Vector(i, j, k);
    }

    public static Vector dotProduct(@NotNull Vector v, @NotNull Vector w) {
        float normalX = (v.getJ() * w.getK()) - (v.getK() * w.getJ());
        float normalY = (v.getK()) * w.getI() - (v.getI() * w.getK());
        float normalZ = (v.getI() * w.getJ()) - (v.getJ() * w.getI());
        return new Vector(normalX, normalY, normalZ);
    }

    public static Vector normalizeVector(@NotNull Vector v) {
        float divisor = Math.abs(v.getI() + v.getJ() + v.getK());
        float oneNormalX = v.getI() / divisor;
        float oneNormalY = v.getJ() / divisor;
        float oneNormalZ = v.getK() / divisor;
        oneNormalX = (oneNormalX == -0.0F) ? 0.0F : oneNormalX;
        oneNormalY = (oneNormalY == -0.0F) ? 0.0F : oneNormalY;
        oneNormalZ = (oneNormalZ == -0.0F) ? 0.0F : oneNormalZ;
        return new Vector(oneNormalX, oneNormalY, oneNormalZ);
    }
}
