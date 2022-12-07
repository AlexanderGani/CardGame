import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //crazy eights
        Card one = new Card("Jack", "Spades", 1);
        one.toString();
        String rank[] = new String[]{"A", "1"};
        String suit[] = new String[]{"Hearts", "Clubs"};
        int point[] = new int[]{1, 2};
        Deck k = new Deck(rank, suit, point);
        k.shuffle();
    }
}
