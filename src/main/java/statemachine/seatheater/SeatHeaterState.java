package statemachine.seatheater;

public enum SeatHeaterState {
    THREE {
        public SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }
    }, TWO {
        public SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }
    }, ONE {
        public SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    }, OFF {
        public SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    };

    public abstract SeatHeaterState next();
}
