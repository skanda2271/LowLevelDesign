package ParkingLotLLD.Vehicle;

class VehicleFactory {
    public static Vehicle createVehicle(String type, String numberPlate) {
        switch (type.toLowerCase()) {
            case "car": return new Car(numberPlate);
            case "bike": return new Bike(numberPlate);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
