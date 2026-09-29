package AuctionBiddingSystem;

public interface Collegue {

    void placeBid(double amount);

    void receiveBidNotification(double bidAmount);

    String getName();
}
