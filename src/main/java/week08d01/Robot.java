package week08d01;

import java.util.Objects;

public class Robot {
    private Point position;

    public Robot(Point position) {
        this.position = position;
    }

    public Point move(String commands) {
        Objects.requireNonNull(commands, "Command cannot be null String.");
        for (int i = 0; i < commands.length(); i++) {
            stepDroid(commands.substring(i, i + 1).toUpperCase());
        }
        return position;
    }

    private void stepDroid(String command) {
        switch (command) {
            case "B":
                position = position.step(Point.of(-1, 0));
                break;
            case "J":
                position = position.step(Point.of(1, 0));
                break;
            case "F":
                position = position.step(Point.of(0, 1));
                break;
            case "L":
                position = position.step(Point.of(0, -1));
                break;
            default:
                throw new IllegalArgumentException("Invalid command: " + command);
        }
    }
}
