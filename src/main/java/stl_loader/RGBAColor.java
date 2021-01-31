package stl_loader;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class RGBAColor implements Serializable {
    private final byte red;
    private final byte green;
    private final byte blue;
    private final byte alpha;

    public RGBAColor(@NotNull byte red, @NotNull byte green, @NotNull byte blue, @NotNull byte alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public byte getRed() {
        return red;
    }

    public byte getGreen() {
        return green;
    }

    public byte getBlue() {
        return blue;
    }

    public byte getAlpha() {
        return alpha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RGBAColor rgbaColor = (RGBAColor) o;
        return red == rgbaColor.red && green == rgbaColor.green && blue == rgbaColor.blue && alpha == rgbaColor.alpha;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue, alpha);
    }

    @Override
    public String toString() {
        return "RGBAColor{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", alpha=" + alpha +
                '}';
    }
}
