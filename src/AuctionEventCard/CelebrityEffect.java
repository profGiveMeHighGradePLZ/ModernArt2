package AuctionEventCard;

import java.util.concurrent.ThreadLocalRandom;

public class CelebrityEffect extends EventCard{
    private String FavorArtist;
    private int Artisit_id;
    public static final String[] ARTIST_NAMES = {"0. Manuel Carvalho", "1. Sigrid Thaler", "2. Daniel Melim", "3. Ramon Martins", "4. Rafael Silveira"};

    public CelebrityEffect(){
        super("Celebrity Effect","A famous celebrity publicly expresses his or her love for a particular artist, causing the price of that artist's work to skyrocket.");
        Artisit_id = ThreadLocalRandom.current().nextInt(4);
        FavorArtist = ARTIST_NAMES[Artisit_id];
    }

    public int getArtisitId() {
        return Artisit_id;
    }
    public String getFavorArtist() {
        return FavorArtist;
    }

    @Override
    public void eventEffect() {
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println(getEventName());
        System.out.println(getDescription());
        System.out.println("The Artist is " + getFavorArtist()+", and the sell price doubled!!!");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

    }

}
