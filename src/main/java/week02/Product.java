package week02;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    public boolean areTheyEqual(Product p){
        return this.name.equals(p.name);
    }

    public static void main(String[] args) {
        Product a = new Product("alma", "trg54");
        Product b = new Product("alma", "df43");
        Product c = new Product("körte", "zhrf4");
        System.out.println(a.areTheyEqual(b));
        System.out.println(a.areTheyEqual(c));
        System.out.println(b.areTheyEqual(c));


    }
}
