package AuctionEventCard;

public class NormalAuction extends EventCard{
    public NormalAuction(){
        super("Normal Auction","Nothing Happened, please This round of auctions was calm and business as usual, with no volatility in the market.");
    }

    @Override
    public void eventEffect() {
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println(getEventName());
        System.out.println(getDescription());
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
    }

}
