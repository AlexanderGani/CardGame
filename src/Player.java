import java.util.ArrayList;
public class Player {
    private ArrayList<Card> hand;
    private String name;
    private int points;
    public Player(String name, int points) {
        ArrayList<Card> hand = new ArrayList<Card>();
        this.name = name;
        points = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int num) {
        points += num;
    }

    public void addCard(Card s) {
        hand.add(s);
    }

    public String toString() {
        return name + " has " + points + " points \n" + name + "'s cards: " + hand;
    }
}
