import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] rank, String[] suit, int[] point) {
        for(int i = 0; i < suit.length; i++) {
            cards = new ArrayList<Card>();
            Card s = new Card(rank[i], suit[i], point[i]);
            cards.add(s);
        }
        cardsLeft = cards.size();
        shuffle();
    }

    public boolean isEmpty() {
        if (cardsLeft == 0) {
            return true;
        }
        return false;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal() {
        if (cardsLeft == 0) {
            return null;
        }
        else {
            cardsLeft--;
            return cards.get(cardsLeft + 1);
        }
    }

    public void shuffle() {
        for(int i = cards.size(); i > 0; i--) {
            int index = (int)(Math.random() * cards.size());
            Card l = cards.get(i);
            cards.remove(i);
            cards.add(i, cards.get(index));
            cards.remove(index);
            cards.add(index, l);
        }
    }
}
