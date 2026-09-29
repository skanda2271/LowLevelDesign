package AuctionBiddingSystem;

public interface ActionMediator {
    void registerBidder(Collegue bidder);

    void placeBid(Collegue bidder, double bidAmount);

    void closeAuction();
}
