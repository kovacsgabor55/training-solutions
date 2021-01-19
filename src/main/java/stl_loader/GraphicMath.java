package stl_loader;

import static java.lang.Math.*;

public class GraphicMath {
    private GraphicMath() {
    }

    public static Normal calculateNormalVector(Vertex v1, Vertex v2, Vertex v3) {
        Vector v = pointsToVector(v2, v1);
        Vector w = pointsToVector(v3, v1);
        Vector d = dotProduct(v, w);
        return normalizeVector(d);
    }

    public static Vector pointsToVector(Vertex v1, Vertex v2) {
        float i = v2.getX() - v1.getX();
        float j = v2.getY() - v1.getY();
        float k = v2.getZ() - v1.getZ();
        return new Vector(i, j, k);
    }

    public static Vector dotProduct(Vector v, Vector w) {
        float normalX = (v.getJ() * w.getK()) - (v.getK() * w.getJ());
        float normalY = (v.getK()) * w.getI() - (v.getI() * w.getK());
        float normalZ = (v.getI() * w.getJ()) - (v.getJ() * w.getI());
        return new Vector(normalX, normalY, normalZ);
    }

    public static Normal normalizeVector(Vector v) {
        //NOTE nem szükséges a négyzetösszeg
        float divisor = abs(v.getI() + v.getJ() + v.getK());
        float oneNormalX = v.getI() / divisor;
        float oneNormalY = v.getJ() / divisor;
        float oneNormalZ = v.getK() / divisor;
        if (oneNormalX == -0.0) {
            oneNormalX = 0;
        }
        if (oneNormalY == -0.0) {
            oneNormalY = 0;
        }
        if (oneNormalZ == -0.0) {
            oneNormalZ = 0;
        }
        return new Normal(oneNormalX, oneNormalY, oneNormalZ);
    }
}
