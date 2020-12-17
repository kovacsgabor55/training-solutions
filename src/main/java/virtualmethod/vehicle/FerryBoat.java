package virtualmethod.vehicle;

public class FerryBoat extends Vehicle {
    public static final int MAX_CARRY_WEIGHT = 2000;
    private Car car = null;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }

    public boolean canCarry(Car car) {
        return car.getGrossLoad() < MAX_CARRY_WEIGHT;
    }

    public boolean load(Car car) {
        if (canCarry(car)) {
            this.car = car;
            return true;
        }
        return false;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + car.getGrossLoad();
    }

    @Override
    public String toString() {
        return "FerryBoat{" + "car=" + car + '}';
    }
}
