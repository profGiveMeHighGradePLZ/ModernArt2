package AuctionEventCard;

public abstract class EventCard {
    private String eventName;
    private String description;
    public EventCard(String eventName,String description){
        this.eventName = eventName;
        this.description = description;
    }

    public String getEventName() {
        return "Game Event: "+eventName;
    }

    public String getDescription() {
        return "Game Event Description: "+description;
    }

    public abstract void eventEffect();
}
