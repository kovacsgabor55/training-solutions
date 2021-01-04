package week03;

import week03d02.Position;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {

    public static void main(String[] args) {
       /* List<Position> positions = new ArrayList<>();
        positions.add(new Position("első", 1541));
        positions.add(new Position("második", 154141));
        positions.add(new Position("harmadik", 11));
        positions.add(new Position("negyedik", 16572));
        positions.add(new Position("ötödik", 165842));


        for (Position item : positions) {
            if (item.getBonus() > 150000) {
                System.out.println(item);
            }
        }*/
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(Position.CEO));
        System.out.println(employees.get(0).getPosition());

    }
}

