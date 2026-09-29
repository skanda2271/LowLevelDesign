package AuctionBiddingSystem;

import java.util.ArrayList;
import java.util.List;

// Concrete Mediator
public class AuctionHouse implements ActionMediator {
    private List<Collegue> bidders;
    private String itemName;
    private double currentHighestBid;
    private Collegue currentHighestBidder;

    public AuctionHouse(String itemName, double startingPrice) {
        this.itemName = itemName;
        this.currentHighestBid = startingPrice;
        this.bidders = new ArrayList<>();
        System.out.println("[+] Auction House created for item: " + itemName + " with initial bid of $" + startingPrice);
    }

    @Override
    public void registerBidder(Collegue bidder) {
        bidders.add(bidder);
        System.out.println("[+] " + bidder.getName() + " has joined the auction for " + itemName);
    }

    @Override
    public void placeBid(Collegue bidder, double bidAmount) {
        // Check if the bid is valid
        if (bidAmount <= currentHighestBid) {
            System.out.println(bidder.getName() + " bid of $" + bidAmount + " is too low. Current highest bid is $" + currentHighestBid);
            // Colleagues are not notified about the bid
            return;
        }

        // Update the highest bid
        currentHighestBid = bidAmount;
        currentHighestBidder = bidder;
        System.out.println("\n===> [New Bid Accepted]" + " Info: {Bidder: " + bidder.getName() + ", Bid Amount: " + bidAmount + "}");
        for (Collegue colleague : bidders) {
            if (!colleague.getName().equals(bidder.getName())) {
                // Notify other bidders about the new bid
                colleague.receiveBidNotification(bidAmount);
            }
        }
    }

    @Override
    public void closeAuction() {
        if (currentHighestBidder != null) {
            System.out.println("\n===> [AUCTION UPDATE]");
            System.out.println("[+] Auction closed! Winner is " + currentHighestBidder.getName() +
                    " with a bid of $" + currentHighestBid + " for " + itemName);
        } else {
            System.out.println("Auction closed with no bids.");
        }
    }

}
