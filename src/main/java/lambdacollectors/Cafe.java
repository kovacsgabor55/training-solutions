package lambdacollectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public void addOrder(CoffeeOrder order){
        orders.add(order);
    }


    public Map<CoffeeType, Long> getCountByCoffeeType(){
        return orders.stream().flatMap(x -> x.getCoffeeList().stream()).collect(Collectors.groupingBy((Coffee x) -> x.getType() , Collectors.counting()));
    }

    public double getAverageOrder(){
        return orders.stream().collect(Collectors.averagingInt(x -> x.getCoffeeList().size()));
    }
}
