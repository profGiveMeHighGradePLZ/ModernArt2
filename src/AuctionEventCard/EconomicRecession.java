package AuctionEventCard;

public class EconomicRecession extends EventCard{
    public EconomicRecession(){
        super("Economic Recession","With the economic downturn, buyers have become more cautious in their bids, leading to a general decline in the sale prices of paintings.");
    }

    @Override
    public void eventEffect() {
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println(getEventName());
        System.out.println(getDescription());
        System.out.println("Game Effect: This round of auctions has been affected by the recession, with all paintings selling for 10 percent less.");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
    }
}
