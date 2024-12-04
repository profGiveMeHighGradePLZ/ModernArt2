package AuctionEventCard;

public class MarketBoom extends EventCard{
    public MarketBoom(){
        super("Market Boom","The art market is experiencing a boom, with buyers clamoring to pay high prices for paintings.");
    }

    @Override
    public void eventEffect() {
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println(getEventName());
        System.out.println(getDescription());
        System.out.println("Game Effect: The selling price for all paintings in this round doubled");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

    }
}
