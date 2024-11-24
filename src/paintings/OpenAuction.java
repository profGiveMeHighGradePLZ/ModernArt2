package paintings;

import players.Player;

public class OpenAuction extends Painting {

    public OpenAuction(int artist_id){
        super(artist_id);
    }
    @Override
    public String getType() {
        return "OpenAuction";
    }

    @Override
    public void auction(Player[] players) {
        boolean deal = false;
        int turn = 0;
        do{
            deal = true;
            for(int i = 0;i<players.length;i++){
                if(turn == players.length && deal)
                    break;
                int bid = players[i].bid(currentBid,this);
                if(bid > currentBid){
                    currentBidder = players[i];
                    currentBid = bid;
                    deal = false;
                    turn = 0;
                }
                turn++;
            }
        }while(!deal);
        super.sold();
    }
}
