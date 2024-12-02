package players;

import paintings.HiddenAuction;
import paintings.Painting;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayer extends Player{
    private int round = 0;
    private int[][] scoreboard;

    public ComputerPlayer(int money,int[][] scoreboard){
        super(money,"Computer "+totalPlayers++);
        this.scoreboard = scoreboard;
    }

    public int bid(int currentBid, Painting p) {
        int potentialValue;
        int bid = 0;

        int carry = 1;
        if(p.getOwner().equals(this))
            carry = 2;
        if(round == 0)
            potentialValue = 30/carry;
        else
            potentialValue = (30+scoreboard[round-1][p.getArtistId()])/carry;

        int tmp = 0;
        if((tmp += currentBid+ ThreadLocalRandom.current().nextInt(15))<potentialValue && tmp <= this.getMoney())
            bid = tmp;

        if(!(p instanceof HiddenAuction)) {
            if(bid == 0)
                System.out.println(this + " pass!");
            else
                System.out.println(this+" bids "+bid);
        }
        return bid;
    }

    @Override
    public Painting playPainting() {
        return handPaintings.remove(ThreadLocalRandom.current().nextInt(handPaintings.size()));
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void sellPainting(int[] scores) {
        round++;
        super.sellPainting(scores);
    }
}
