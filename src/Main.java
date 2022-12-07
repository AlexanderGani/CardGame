import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //crazy eights
        Card one = new Card("Jack", "Spades", 1);
        one.toString();
        String rank[] = new String[]{"A", "2", "3"};
        String suit[] = new String[]{"Hearts", "Clubs"};
        int point[] = new int[]{1, 2, 3};
        Deck k = new Deck(rank, suit, point);
        System.out.print(k.deal());
        k.shuffle();
        System.out.print(k.deal());

    }
}
