package week14d04;

import java.util.ArrayList;
import java.util.List;

public class ContractCreator {
    Contract template;

    public ContractCreator(String client, List<Integer> monthlyPrices) {
        this.template = new Contract(client, monthlyPrices);
    }

    public Contract create(String name) {
        return new Contract(name, new ArrayList<>(template.getMonthlyPrices()));
    }

    public Contract getTemplate() {
        return template;
    }

    public static void main(String[] args) {
        ContractCreator cc = new ContractCreator("John Doe", List.of(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
        Contract john = cc.create("John Smith");
        john.getMonthlyPrices().set(1, 20);

        System.out.println(john.getMonthlyPrices());
        System.out.println(cc.getTemplate().getMonthlyPrices());
    }
}

















