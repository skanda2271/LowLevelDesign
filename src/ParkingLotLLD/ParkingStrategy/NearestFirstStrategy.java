package ParkingLotLLD.ParkingStrategy;

import ParkingLotLLD.Parking.ParkingFloor;
import ParkingLotLLD.Parking.ParkingSpot;
import ParkingLotLLD.Vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class NearestFirstStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        for(ParkingFloor floor : floors){
            Optional<ParkingSpot> spot = floor.getAllAvialableSpots(vehicle);
            if(spot.isPresent()){
                return spot;
            }
        }
        return Optional.empty();
    }
}
