package players;

import paintings.Painting;

public class AFKPlayer extends Player{
    public AFKPlayer(int money){
        super(money,"AFK"+totalPlayers++);
    }

    @Override
    public int bid(int currentBid, Painting p) {
        return 0;
    }

    @Override
    public Painting playPainting() {
        System.out.println("The AFKPlayer put up a painting by "+handPaintings.get(0).getArtistName());
        return handPaintings.remove(0);
    }


    @Override
    public int hiddenBid(int currentBid, Painting p) {
        return 0;
    }
}
