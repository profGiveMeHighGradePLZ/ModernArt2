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
        return handPaintings.remove(0);
    }
}
