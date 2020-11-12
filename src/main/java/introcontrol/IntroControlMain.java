package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl l = new IntroControl();
        System.out.println(l.substractTenIfGreaterThanTen(10));

        System.out.println(l.substractTenIfGreaterThanTen(9));

        System.out.println(l.substractTenIfGreaterThanTen(11));


        System.out.println(l.describeNumber(0));
        System.out.println(l.describeNumber(2));

        System.out.println(l.greetingToJoe("Joe"));
        System.out.println(l.greetingToJoe("Don"));

        System.out.println(l.calculateBonus(12541));
        System.out.println(l.calculateBonus(1254148));

        System.out.println(l.calculateConsumption(45, 50));
        System.out.println(l.calculateConsumption(50, 45));

        l.printNumbers(10);

        l.printNumbersBetween(5, 10);

        l.printNumbersBetweenAnyDirection(5, 10);
        l.printNumbersBetweenAnyDirection(10, 5);

        l.printOddNumbers(10);
        l.printOddNumbers(11);
    }
}
