package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> ships;
    private int waitingPersons;
    private int waitingCargo;

    public Fleet() {
        this.ships = new ArrayList<>();
    }

    public void loadShip(int passengers, int cargoWeight) {
        waitingPersons = passengers;
        waitingCargo = cargoWeight;

        for (Ship item : ships) {
            if (item instanceof CanCarryPassengers) {
                waitingPersons = ((CanCarryPassengers) item).loadPassenger(waitingPersons);
            }
            if (item instanceof CanCarryGoods) {
                waitingCargo = ((CanCarryGoods) item).loadCargo(waitingCargo);
            }
        }
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }

    public void addShip(Ship ship) {
        this.ships.add(ship);
    }
}
