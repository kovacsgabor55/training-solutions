package week05d04;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate expire;

    public Product(String name, int year, int month, int day) {
        this.name = name;
        this.expire = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpire() {
        return expire;
    }

    public void setExpire(LocalDate expire) {
        this.expire = expire;
    }


}
