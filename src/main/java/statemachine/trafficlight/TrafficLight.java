package statemachine.trafficlight;

public enum TrafficLight {
    RED_YELLOW {
        @Override
        public TrafficLight next() {
            return GREEN;
        }
    }, GREEN {
        @Override
        public TrafficLight next() {
            return YELLOW;
        }
    }, YELLOW {
        @Override
        public TrafficLight next() {
            return RED;
        }
    }, RED {
        @Override
        public TrafficLight next() {
            return RED_YELLOW;
        }
    };

    abstract public TrafficLight next();
}
