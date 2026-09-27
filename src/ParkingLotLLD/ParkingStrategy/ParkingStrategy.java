package ParkingLotLLD.ParkingStrategy;

import ParkingLotLLD.Parking.ParkingFloor;
import ParkingLotLLD.Parking.ParkingSpot;
import ParkingLotLLD.Vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
