package players;


import paintings.Painting;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {
   /**
     * The name of the player
     * 
     * The first player should have the name "[PlayerType] 0"
     * The second player should have the name "[PlayerType] 1"
     * The third player should have the name "[PlayerType] 2"
     * ...
     * PlayerType is set to Player for human player, 
     * and Computer for Computer Player, AFK for AFK player...
     */
    private final String name;
    /**
     * The money the player has
     */
    private int money;
    /**
     * The total number of players in the game
     */
    protected static int totalPlayers = 0;
    /**
     * The paintings the player has in hand
     */
    protected List<Painting> handPaintings = new ArrayList<>();
    /**
     * The paintings the player has bought
     */
    protected List<Painting> boughtPaintings = new ArrayList<>();
    /**
     * Constructor of the Player class
     */
    public Player(int money, String name) {
        this.money = money;
        this.name = name;
    }
    /**
     * Constructor of the Player class
     */
    public Player(int money) {
        this(money, "Player " + totalPlayers++);
    }
    /**
     * To deal a painting to the player
     */
    public void dealPaintings(Painting painting) {
        handPaintings.add(painting);
        painting.setOwner(this);
    }
    /**
     * Get the name of the player
     */
    public final String getName() {
        return name;

    }
    /**
     * To let the player to put up a painting for auction
     * After this method, the painting should be removed from handPaintings
     */
    private boolean validPaintingInput(int index) throws Exception{
        if(index < 0 || handPaintings.size() < index )
            throw new Exception("Error input! No Such Painting");
        return true;
    }
    public Painting playPainting() {
        Scanner in = new Scanner(System.in);
        int index;
        while(true) {
            System.out.println(getName()+" has $" + getMoney());
            for(int i = 0;i<handPaintings.size();i++){
                System.out.println(i+": "+handPaintings.get(i));
            }
            System.out.print("Please enter the index of the painting you want to play: ");
            try {
                index = in.nextInt();
                if (validPaintingInput(index)) {
                    return handPaintings.remove(index);
//                    break;
                }
            }catch (InputMismatchException e){
                in.nextLine();
                System.out.println("Error:" + e.getMessage());
            }
            catch (Exception e) {
                in.nextLine();
                System.out.println("Error: "+e);
            }
        }
//        System.out.println("The player put up a painting by "+handPaintings.get(index).getArtistName());
//        return handPaintings.remove(index);
    }
    /**
     * Get the money the player has
     */
    public final int getMoney() {
        return money;
    }
    /**
     * 
     * To let the player to bid. 
     * 
     * In some auctions, e.g. open auction, the player knows the current bid.
     * In this case the currentBid will be passed to the method.
     * 
     * In some auctions, e.g. blind auction, the player does not know the current bid.
     * In this case, the currentBid passed to the method will be 0.
     * 
     * A human player should be asked to input the bid amount.
     * The bid amount should be less than or equal to the money the player has.
     * If the bid amount is too high, the player should be asked to input again.
     * 
     * If the bid amount is too small (less than the current bid or less than 1),
     * the bid amount will also be returned, which may means to pass the bid.
     * 
     */
    public int bid(int currentBid, Painting p) {
        return bid(currentBid);
    }

    /**
     * 
     * This old version is deprecated and shall not be used
     * outside this package.
     */
    @Deprecated
    protected int bid(int currentBid) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(this);
                System.out.print("Enter your bid (enter 0 = forfeit): ");
                int bid = scanner.nextInt();
                if (bid > money)
                    continue;
                return bid;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        } while (true);
    }
    /**
     * To let the player to pay
     */
    public void pay(int amount) {
        money-=amount;
    }
    /**
     * To let the player to earn
     */
    public void earn(int amount) {
        money+=amount;
    }
    /**
     * toString method that you need to override
     */
    public String toString() {
        return getName() + " has $" + getMoney();
//        return getName();
    }
    /**
     * To finalize a bid and purchase a painting
     * 
     */
    public void buyPainting(Painting Painting) {
        boughtPaintings.add(Painting);
    }
    /**
     * To sell all the paintings the player has bought to the bank 
     * after each round
     */    
    public void sellPainting(int[] scores) {
        for(Painting p:boughtPaintings){
            earn(scores[p.getArtistId()]);
        }
        boughtPaintings.clear();

    }

}
