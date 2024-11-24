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
        super.auction(players);
    }
}
