package immutable.satellite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpaceAgency {
    private List<Satellite> satellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        Objects.requireNonNull(satellite, "Parameter must not be null!");
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent) {
        for (Satellite item : satellites) {
            if (item.getRegisterIdent().equals(registerIdent)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Satellite with the given registration cannot be found!");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < satellites.size(); i++) {
            stringBuilder.append(satellites.get(i).toString());
            if (i < satellites.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
