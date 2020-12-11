package week07d05;

public class Motorcycle extends Vehicle {
    private int numberOfGears;

    public Motorcycle(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    @Override
    public int getNumberOfGears() {
        return this.numberOfGears;
    }

    @Override
    public TransmissionType getTransmissionType() {
        return TransmissionType.SEQUENTIAL;
    }
}
