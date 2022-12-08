import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private Player o;
    private Player x;

    private Deck one;
    public Game() {
        o = new Player("null", 0);
        x = new Player("null", 0);
        String[] ranks = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = new String[]{"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] points = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        one = new Deck(ranks, suits, points);
    }

    public void win(Player s) {
        System.out.println(s.getName() + " wins!");
    }

    public void printInstructions() {
        System.out.println("Crazy Eights:\n" + "The rules are simple, try to get rid of all of your cards, " +
                "but you can only discard you card if it matches the rank or suit, or if it is an 8 of any kind\n" +
                "if you can't discard a card, draw from the deck until you are able to.");
    }

    public void playGame() {
        Scanner scan = new Scanner(System.in);
        printInstructions();
        //if cardsLeft in hand == 0, call win check, else continue - also present options based on next card in rotation
        System.out.println("Player, what is your name?");
        String name = scan.nextLine();
        o.setName(name);
        System.out.println("Single Player or Two players (input 1 or 2):");
        int choice = scan.nextInt();

        if (choice == 1) {
            x.setName("Computer");
        }
        else if(choice == 2) {
            System.out.println("Player 2 what is your name?");
            String name2 = scan.nextLine();
            x.setName(name2);
        }
        else {
            System.out.println("Invalid input");
        }
        for(int i = 0; i <= 5; i++) {
            o.addCard(one.deal());
        }
        for(int j = 0; j <= 5; j++) {
            x.addCard(one.deal());
        }
        Card current = one.deal();
        System.out.println("First Card is " + current);
        while(!one.isEmpty() || !o.getHand().isEmpty() || !x.getHand().isEmpty()) {
            //one needs to be presented options
            System.out.println("Player one turn: ");

                for (int m = 0; m < o.getHand().size(); m++) {
                    if(o.getCard(m).getSuit().equals(current.getSuit())
                            || o.getCard(m).getRank().equals(current.getRank()) || o.getCard(m).getRank().equals("8")) {
                        System.out.println("Select option (1/2)\n1. Discard " + o.getCard(m) + "\n2. draw");
                        int choice2 = scan.nextInt();
                        while (!(choice2 == 1) && !(choice2 == 2)) {
                            System.out.println("Invalid Input, input option 1 or 2");
                            choice2 = scan.nextInt();
                        }
                        if (choice2 == 1) {
                            current = o.getCard(m);
                            System.out.println("Current card is " + o.getCard(m));
                            o.removeCard(o.getCard(m));
                            System.out.println("Hand " + o.getHand());
                        }
                        else {
                            Card drew = one.deal();
                            o.addCard(drew);
                            System.out.println("Drew a " + drew);
                            break;
                        }

                    }

                }

                System.out.println("Can't discard, drawing");
                Card drew = one.deal();
                o.addCard(drew);
                System.out.println("Drew a " + drew);
                System.out.println("Cards" + one.getCardsLeft());

                System.out.println("Player two turn: ");
                for(int n = 0; n < x.getHand().size(); n++) {
                    if(x.getCard(n).getSuit().equals(current.getSuit())
                            || x.getCard(n).getRank().equals(current.getRank()) || x.getCard(n).getRank().equals("8")) {
                        System.out.println("Select option (1/2)\n1. Discard " + x.getCard(n) + "\n2. draw");
                        int choice2 = scan.nextInt();
                        while (!(choice2 == 1) && !(choice2 == 2)) {
                            System.out.println("Invalid Input, input option 1 or 2");
                            choice2 = scan.nextInt();
                        }
                        if (choice2 == 1) {
                            System.out.println("Current card is " + x.getCard(n));
                            current = x.getCard(n);
                            x.removeCard(x.getCard(n));
                            System.out.println("Hand: " + x.getHand());
                        } else {
                            drew = one.deal();
                            x.addCard(drew);
                            System.out.println("Drew a " + drew);
                            break;
                        }
                    }
                }

                System.out.print("Can't discard, drawing");
                drew = one.deal();
                x.addCard(drew);
                System.out.println("Drew a " + drew);
        }

        if(o.getHand().isEmpty() && x.getHand().isEmpty()) {
            System.out.println("It's a draw");
        }
        else if (o.getHand().isEmpty()) {
            win(o);
        }

        else {
            win(x);
        }
    }
}


