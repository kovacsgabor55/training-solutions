package week07d05;

public class Car extends Vehicle {
    private int numberOfGears;

    public Car(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    @Override
    public int getNumberOfGears() {
        return this.numberOfGears;
    }

    @Override
    public TransmissionType getTransmissionType() {
        return TransmissionType.AUTOMATIC;
    }
}
