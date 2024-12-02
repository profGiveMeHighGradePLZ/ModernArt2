package paintings;

import players.Player;

public class OpenAuctionPainting extends Painting {

    public OpenAuctionPainting(int artist_id){
        super(artist_id);
    }
    @Override
    public String getType() {
        return "Open Auction";
    }

    @Override
    public void auction(Player[] players) {
        boolean deal = false;
        int turn = 0;
        int startIndex = 0;
        for(int i = 0;i< players.length;i++){
            if(players[i].equals(owner)){
                startIndex = i;
                break;
            }
        }
        do{
            deal = true;
            for(int i = 0;i<players.length;i++){
                if(turn == players.length && deal)
                    break;
                int bid = players[(i+startIndex)% players.length].bid(currentBid,this);
                if(bid > currentBid){
                    currentBidder = players[(i+startIndex)% players.length];
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
