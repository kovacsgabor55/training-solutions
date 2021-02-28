package covid;

import java.util.Objects;

public class ZipCode {
    private final int zipCode;
    private final String city;
    private final String district;

    public ZipCode(int zipCode, String city, String district) {
        this.zipCode = zipCode;
        this.city = city;
        this.district = district;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode1 = (ZipCode) o;
        return zipCode == zipCode1.zipCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode);
    }
}
