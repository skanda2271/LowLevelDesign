package ParkingLotLLD.FeeStrategy;

import ParkingLotLLD.Parking.ParkingTicket;

public interface ParkingFeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
