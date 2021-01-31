package stl_loader;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class Material implements Serializable {
    private final RGBAColor diffuse;
    private final RGBAColor specular;
    private final RGBAColor ambient;

    public Material(@NotNull RGBAColor diffuse, @NotNull RGBAColor specular, @NotNull RGBAColor ambient) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.ambient = ambient;
    }

    public RGBAColor getDiffuse() {
        return diffuse;
    }

    public RGBAColor getSpecular() {
        return specular;
    }

    public RGBAColor getAmbient() {
        return ambient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return diffuse.equals(material.diffuse) && specular.equals(material.specular) && ambient.equals(material.ambient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diffuse, specular, ambient);
    }

    @Override
    public String toString() {
        return "Material{" +
                "diffuse=" + diffuse +
                ", specular=" + specular +
                ", ambient=" + ambient +
                '}';
    }
}
