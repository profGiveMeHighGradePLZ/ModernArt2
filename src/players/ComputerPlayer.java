package players;

import paintings.Painting;

public class ComputerPlayer extends Player{

    private int[][] scoreboard = new int[4][Painting.ARTIST_NAMES.length];

    public ComputerPlayer(int money,int[][] scoreboard){
        super(money,"Computer"+totalPlayers++);
        this.scoreboard = scoreboard;
    }

    @Override
    public int hiddenBid(int currentBid, Painting p) {
        return super.hiddenBid(currentBid, p);
    }
}
