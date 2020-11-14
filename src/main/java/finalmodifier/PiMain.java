package finalmodifier;

public class PiMain {
    public static void main(String[] args) {
        CylinderCalculator cylinderCalculator=new CylinderCalculator();
        CircleCalculator circleCalculator=new CircleCalculator();
        System.out.println(CircleCalculator.PI);

        System.out.println(cylinderCalculator.calculateSurfaceArea(2,3));
        System.out.println(cylinderCalculator.calculateVolume(4,5));

        System.out.println(circleCalculator.calculateArea(5));
        System.out.println(circleCalculator.calculatePerimeter(5));
    }
}
