package ParkingLotLLD.FeeStrategy;

import ParkingLotLLD.Parking.ParkingTicket;
import ParkingLotLLD.Vehicle.VehicleSize;

public class FlatRateStrategy implements ParkingFeeStrategy{
    private static final double RATE_PER_HOUR = 10.0;
    @Override
    public double calculateFee(ParkingTicket ticket) {
        long duration = ticket.getEntryTimeStamp() - ticket.getExitTimeStamp();
        long hours = (duration / (1000 * 60 * 60) + 1);
        if(ticket.getVehicle().getSize() == VehicleSize.SMALL){
            return hours * RATE_PER_HOUR;
        }
        return hours * RATE_PER_HOUR * 2;
    }
}
