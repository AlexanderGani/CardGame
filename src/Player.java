import java.util.ArrayList;
public class Player {
    private ArrayList<Card> hand;
    private String name;
    private int points;
    public Player(String name, int points) {
        hand = new ArrayList<Card>();
        this.name = name;
        points = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int num) {
        points += num;
    }

    public Card getCard(int s) {
        return hand.get(s);
    }
    public void addCard(Card s) {
        hand.add(s);
    }

    public void removeCard(Card s) {
        hand.remove(s);
    }

    public String toString() {
        return name + " has " + points + " points \n" + name + "'s cards: " + hand;
    }
}
