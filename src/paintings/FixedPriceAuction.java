package paintings;

import players.Player;

public class FixedPriceAuction extends OpenAuction{
    public FixedPriceAuction(int artist_id){
        super(artist_id);
    }

    @Override
    public String getType() {
        return "FixedPriceAuction";
    }

    @Override
    public void auction(Player[] players) {
        int startIndex = 0;
        for(int i = 0;i< players.length;i++){
            if(players[i].equals(getOwner())){
                currentBidder = players[i];
                System.out.println(players[i].getName()+", please fix a price for the auction");
                currentBid = players[i].bid(currentBid,this);
                startIndex = i+1;
                break;
            }
        }
        for(int i = 0;i< players.length;i++){
            int bid = players[(i+startIndex)% players.length].bid(currentBid,this);
            if(bid >= currentBid){
                currentBidder = players[(i+startIndex)% players.length];
                super.sold();
                return;
            }
            else{
                System.out.println(players[(i+startIndex)% players.length]+" pass.");
            }
        }
        super.sold();
    }
}
