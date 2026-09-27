package ParkingLotLLD.Parking;

import ParkingLotLLD.Vehicle.Vehicle;

import java.util.UUID;

public class ParkingTicket {
    private final String ticketId;
    private final ParkingSpot parkingSpot;
    private  final Vehicle vehicle;
    private final long entryTimeStamp;
    private long exitTimeStamp;

    public ParkingTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.ticketId = UUID.randomUUID().toString();
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.entryTimeStamp = System.nanoTime();
    }

    public void setExitTimeStamp(long exitTimeStamp) {
        this.exitTimeStamp = exitTimeStamp;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public long getExitTimeStamp() {
        return exitTimeStamp;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "ticketId='" + ticketId + '\'' +
                ", parkingSpot=" + parkingSpot +
                ", vehicle=" + vehicle +
                ", entryTimeStamp=" + entryTimeStamp +
                ", exitTimeStamp=" + exitTimeStamp +
                '}';
    }
}
