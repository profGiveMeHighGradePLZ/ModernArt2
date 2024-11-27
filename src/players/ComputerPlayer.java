package players;

import paintings.HiddenAuction;
import paintings.Painting;

public class ComputerPlayer extends Player{

    private int[][] scoreboard = new int[4][Painting.ARTIST_NAMES.length];

    public ComputerPlayer(int money,int[][] scoreboard){
        super(money,"Computer"+totalPlayers++);
        this.scoreboard = scoreboard;
    }

    public int bid(int currentBid, Painting p) {
        if(!(p instanceof HiddenAuction)) {
            System.out.println(this+" bids 10");
        }
        return 10;
    }

    @Override
    public Painting playPainting() {
        return handPaintings.remove(0);
    }



    @Override
    public int hiddenBid(int currentBid, Painting p) {
        return super.hiddenBid(currentBid, p);
    }


    @Override
    public String toString() {
        return getName();
    }
}
