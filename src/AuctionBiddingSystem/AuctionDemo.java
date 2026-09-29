package AuctionBiddingSystem;

public class AuctionDemo {
    public static void main(String[] args) {
        System.out.println("\n###### Mediator Design Pattern ######");
        System.out.println("\n===> Welcome to the Auction House!\n");

        // Create a Mediator
        ActionMediator auctionHouse = new AuctionHouse("Vintage Guitar", 100.0);

        // Create Colleagues/Components
        Collegue alice = new Bidder("Alice", auctionHouse);
        Collegue bob = new Bidder("Bob", auctionHouse);
        Collegue charlie = new Bidder("Charlie", auctionHouse);

        // Register Colleagues/Components with Mediator - AuctionHouse Constructor

        // Use Colleagues/Components
        alice.placeBid(150.0);
        bob.placeBid(250.0);
        charlie.placeBid(300.0);
        alice.placeBid(300.0); // Will not be accepted
        bob.placeBid(900.0); // Winner

        // Admin closes the auction
        auctionHouse.closeAuction();

    }
}
