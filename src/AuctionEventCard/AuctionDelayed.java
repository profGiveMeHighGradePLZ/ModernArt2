package AuctionEventCard;

public class AuctionDelayed extends EventCard{
    public AuctionDelayed(){
        super("Auction delayed","The auction was delayed for some reason, which affected part of the auction.");
    }

    @Override
    public void eventEffect() {
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println(getEventName());
        System.out.println(getDescription());
        System.out.println("Game Effect: The number of max painting in the current round has been reduced by half");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

    }
}
