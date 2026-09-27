package ParkingLotLLD.Parking;

import ParkingLotLLD.Vehicle.Vehicle;
import ParkingLotLLD.Vehicle.VehicleSize;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<Integer, ParkingSpot> spots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ConcurrentHashMap<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Map<Integer, ParkingSpot> getSpots() {
        return spots;
    }

    public void addSpot(ParkingSpot spot){
        spots.put(spot.getSpotId(), spot);
    }

    public void displayAllSpots(){
        System.out.println("---Floor Availabalaity ---\n" + floorNumber);
        Map<VehicleSize,Long> map = spots.values().stream()
                .filter(spot -> !spot.getOccupied())
                .collect(Collectors.groupingBy(ParkingSpot::getSpotsize, Collectors.counting()));
        for(VehicleSize size : VehicleSize.values()){
            System.out.println( size + "-->" + map.getOrDefault(size, 0L));
        }
    }

    public Optional<ParkingSpot> getAllAvialableSpots(Vehicle vehicle){
        return spots.values().stream()
                .filter(spot -> !spot.getOccupied() && spot.isFitToPark(vehicle))
                .sorted(Comparator.comparing(ParkingSpot::getSpotsize))
                .findFirst();
    }
}
