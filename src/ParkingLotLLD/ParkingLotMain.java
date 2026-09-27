package ParkingLotLLD;

import ParkingLotLLD.FeeStrategy.FlatRateStrategy;
import ParkingLotLLD.Parking.ParkingFloor;
import ParkingLotLLD.Parking.ParkingSpot;
import ParkingLotLLD.Parking.ParkingTicket;
import ParkingLotLLD.ParkingStrategy.NearestFirstStrategy;
import ParkingLotLLD.Vehicle.Bike;
import ParkingLotLLD.Vehicle.Car;
import ParkingLotLLD.Vehicle.Vehicle;
import ParkingLotLLD.Vehicle.VehicleSize;

import java.util.Optional;

public class ParkingLotMain {
    public static void main(String[] args){
        ParkingLotManager parkingLotManager = ParkingLotManager.getParkinglotManager();
        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addSpot(new ParkingSpot(1, VehicleSize.SMALL));
        floor1.addSpot(new ParkingSpot(2, VehicleSize.SMALL));
        floor1.addSpot(new ParkingSpot(3, VehicleSize.MEDIUM));
        floor1.addSpot(new ParkingSpot(4, VehicleSize.MEDIUM));

        ParkingFloor floor2 = new ParkingFloor(2);
        floor2.addSpot(new ParkingSpot(5, VehicleSize.SMALL));
        floor2.addSpot(new ParkingSpot(6, VehicleSize.SMALL));
        floor2.addSpot(new ParkingSpot(7, VehicleSize.MEDIUM));
        floor2.addSpot(new ParkingSpot(8, VehicleSize.MEDIUM));

        parkingLotManager.addFloor(floor1);
        parkingLotManager.addFloor(floor2);

        parkingLotManager.setParkingFeeStrategy(new FlatRateStrategy());
        parkingLotManager.setParkingStrategy(new NearestFirstStrategy());

        floor1.displayAllSpots();
        floor2.displayAllSpots();

        Vehicle bike = new Bike("1256");
        Vehicle car = new Car("569");

        Optional<ParkingTicket> bikeTicket = parkingLotManager.parkVehicle(bike);
        Optional<ParkingTicket> carTicket = parkingLotManager.parkVehicle(car);

        System.out.println(bikeTicket.toString());

        Optional<Double> bikeTicketFee = parkingLotManager.unParkVehicle(bike);
        System.out.println(bikeTicketFee);


    }



}
