package AuctionBiddingSystem;

public class Bidder implements Collegue{
    String name;
    ActionMediator mediator;

    public Bidder(String name, ActionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.registerBidder(this);
    }

    @Override
    public void placeBid(double amount) {
        System.out.println("\n===> [Placing Bid] " + name + " is attempting to bid $" + amount);
        mediator.placeBid(this, amount);
    }

    @Override
    public void receiveBidNotification(double bidAmount) {
        System.out.println("[+] Bidder " + name + " has received a new bid notification of: " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}
