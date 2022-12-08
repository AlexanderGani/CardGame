import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] rank, String[] suit, int[] point) {
        cards = new ArrayList<Card>();
        //needs to reset after i reaches max value, keep other thing constant
        for (int j = 0; j < suit.length; j++) {
            for (int i = 0; i < rank.length; i++) {
                Card s = new Card(rank[i], suit[j], point[i]);
                cards.add(s);
            }
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
            return cards.get(cardsLeft);
        }
    }

    public void shuffle() {
        for(int i = cardsLeft - 1; i > 0; i--) {
            int index = (int)(Math.random() * cardsLeft - 1);
            Card j = cards.get(index);
            cards.set(index, cards.get(i));
            cards.set(i, j);
            }
        }
    }

