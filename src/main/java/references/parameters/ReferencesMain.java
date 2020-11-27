package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person person1, person2;
        person1 = new Person("", 1);
        person2 = person1;
        person2.setName("f");
        System.out.println(person1);
        System.out.println(person2);
        int a, b;
        a = 24;
        b = a;
        b += 1;
        System.out.println(a);
        System.out.println(b);
        person2 = new Person("g", a);
        System.out.println(person1);
        System.out.println(person2);

    }
}
