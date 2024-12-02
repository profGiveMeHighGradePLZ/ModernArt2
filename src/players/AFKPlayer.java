package players;

import paintings.HiddenAuctionPainting;
import paintings.Painting;

public class AFKPlayer extends Player{
    public AFKPlayer(int money){
        super(money,"AFK"+totalPlayers++);
    }

    @Override
    public int bid(int currentBid, Painting p) {
        if(!(p instanceof HiddenAuctionPainting)) {
            System.out.println(this+" bids 0");
        }
        return 0;
    }

    @Override
    public Painting playPainting() {
        return handPaintings.remove(0);
    }


    @Override
    public String toString() {
        return getName();
    }
}
