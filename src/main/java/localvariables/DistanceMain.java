package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance di = new Distance(41.2, true);
        System.out.println("Távolság: " + di.getDistanceInKm() + "Km Pontos: " + di.isExact());
        int variable = (int) di.getDistanceInKm();
        System.out.println(variable);
    }
}
