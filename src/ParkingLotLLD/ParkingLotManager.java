package ParkingLotLLD;

import ParkingLotLLD.FeeStrategy.FlatRateStrategy;
import ParkingLotLLD.FeeStrategy.ParkingFeeStrategy;
import ParkingLotLLD.Parking.ParkingFloor;
import ParkingLotLLD.Parking.ParkingSpot;
import ParkingLotLLD.Parking.ParkingTicket;
import ParkingLotLLD.ParkingStrategy.NearestFirstStrategy;
import ParkingLotLLD.ParkingStrategy.ParkingStrategy;
import ParkingLotLLD.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLotManager {
    private static ParkingLotManager instance;
    private final List<ParkingFloor> parkingFloorList = new ArrayList<>();
    private final Map<String, ParkingTicket> activeTickets;
    private ParkingFeeStrategy parkingFeeStrategy;
    private ParkingStrategy parkingStrategy;

    public ParkingLotManager() {
        this.activeTickets = new ConcurrentHashMap<>();
        this.parkingFeeStrategy = new FlatRateStrategy();
        this.parkingStrategy = new NearestFirstStrategy();
    }

    public static ParkingLotManager getParkinglotManager(){
        if(instance == null){
            synchronized (ParkingLotManager.class){
                if(instance == null){
                    instance = new ParkingLotManager();
                    return instance;
                }
            }
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor){
        parkingFloorList.add(floor);
    }

    public void setParkingFeeStrategy(ParkingFeeStrategy parkingFeeStrategy){
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;
    }

    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle){
        Optional<ParkingSpot> avilableSpot = parkingStrategy.findSpot(parkingFloorList, vehicle);
        if(avilableSpot.isPresent()){
            ParkingSpot parkingSpot = avilableSpot.get();
            parkingSpot.parkVehicle(vehicle);
            ParkingTicket ticket = new ParkingTicket(parkingSpot, vehicle);
            activeTickets.put(vehicle.getNumber(),ticket);
            System.out.println("parkedVehicle --> " + vehicle.getNumber() + " -> " +parkingSpot.getSpotId());
            return Optional.of(ticket);
        }
        System.out.println("Slots not avilable");
        return Optional.empty();
    }

    public Optional<Double> unParkVehicle(Vehicle vehicle){
        String lisenceNumber = vehicle.getNumber();
        ParkingTicket ticket = activeTickets.remove(lisenceNumber);
        if(ticket == null){
            System.out.println("Vehicle not found");
            return Optional.empty();
        }
        ticket.setExitTimeStamp(System.nanoTime());
        ticket.getParkingSpot().unPark(vehicle);
        Double fee = parkingFeeStrategy.calculateFee(ticket);
        return Optional.of(fee);
    }

}
