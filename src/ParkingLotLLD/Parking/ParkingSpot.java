package ParkingLotLLD.Parking;

import ParkingLotLLD.Vehicle.Vehicle;
import ParkingLotLLD.Vehicle.VehicleSize;

public class ParkingSpot {
    private int spotId;
    private VehicleSize spotsize;
    private Boolean isOccupied = false;
    private Vehicle parkedVehicle = null;

    public ParkingSpot(int spotId, VehicleSize spotsize) {
        this.spotId = spotId;
        this.spotsize = spotsize;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public void setSpotsize(VehicleSize spotsize) {
        this.spotsize = spotsize;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public int getSpotId() {
        return spotId;
    }

    public VehicleSize getSpotsize() {
        return spotsize;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId=" + spotId +
                ", spotsize=" + spotsize +
                ", isOccupied=" + isOccupied +
                ", parkedVehicle=" + parkedVehicle +
                '}';
    }

    public void parkVehicle(Vehicle vehicle){
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

    public void unPark(Vehicle vehicle){
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public boolean isFitToPark(Vehicle vehicle){
        if(isOccupied){
            return false;
        }
        if(vehicle.getSize() == this.spotsize){
            return true;
        }
        return false;
    }
}
