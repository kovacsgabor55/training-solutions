package week03;

import week03d02.Position;

public class Employee {
    private Position position;

    public Employee(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
