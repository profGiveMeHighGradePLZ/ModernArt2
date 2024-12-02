package paintings;

import players.Player;

public class OneOfferAuctionPainting extends Painting{
    public OneOfferAuctionPainting(int artist_id){
        super(artist_id);
    }

    @Override
    public String getType() {
        return "One Offer Auction";
    }

    @Override
    public void auction(Player[] players) {
        int startIndex = 0;
        for(int i = 0;i< players.length;i++){
            if(players[i].equals(getOwner())){
                startIndex = i+1;
                break;
            }
        }
        for(int i = 0;i<players.length;i++){
            int bid = players[(i+startIndex)% players.length].bid(currentBid,this);
            if(bid > currentBid){
                currentBidder = players[(i+startIndex)% players.length];
                currentBid = bid;
            }
        }
        super.sold();
    }
}