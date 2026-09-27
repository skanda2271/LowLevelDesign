package ParkingLotLLD.Vehicle;

public abstract class Vehicle {
    private final String number;
    private final VehicleSize size;

    public Vehicle(String number, VehicleSize size) {
        this.number = number;
        this.size = size;
    }

    public String getNumber() {
        return number;
    }

    public VehicleSize getSize() {
        return size;
    }
}
