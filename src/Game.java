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
        System.out.print(s.getName() + " wins!");
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
            int k = 0;
            do {
                if (k >= o.getHand().size() || o.getHand().isEmpty()) {
                    break;
                }
                while (o.getCard(k).getSuit().equals(current.getSuit())
                        || o.getCard(k).getRank().equals(current.getRank()) || o.getCard(k).getRank().equals("8")) {
                    System.out.println("Select option (1/2)\n1. Discard " + o.getCard(k) + "\n2. draw");
                    int choice2 = scan.nextInt();
                    while (!(choice2 == 1) && !(choice2 == 2)) {
                        System.out.println("Invalid Input, input option 1 or 2");
                        choice2 = scan.nextInt();
                    }
                    if (choice2 == 1) {
                        current = o.getCard(k);
                        System.out.println("Current card is " + o.getCard(k));
                        o.removeCard(o.getCard(k));
                        System.out.println("Hand " + o.getHand());
                    } else {
                        Card drew = one.deal();
                        o.addCard(drew);
                        System.out.println("Drew a " + drew);
                        break;
                    }
                }
                System.out.println("Can't discard, drawing");
                Card drew = one.deal();
                o.addCard(drew);
                System.out.println("Drew a " + drew);
                System.out.println("Cards" + one.getCardsLeft());
                k++;
            }
            while (k < o.getHand().size() - 1);

            System.out.println("Player two turn: ");
            int l = 0;
            do {
                if (l >= x.getHand().size() || x.getHand().isEmpty()) {
                    break;
                }
                while (x.getCard(l).getSuit().equals(current.getSuit())
                        || x.getCard(l).getRank().equals(current.getRank()) || x.getCard(l).getRank().equals("8")) {
                    System.out.println("Select option (1/2)\n1. Discard " + x.getCard(l) + "\n2. draw");
                    int choice2 = scan.nextInt();
                    while (!(choice2 == 1) && !(choice2 == 2)) {
                        System.out.println("Invalid Input, input option 1 or 2");
                        choice2 = scan.nextInt();
                    }
                    if (choice2 == 1) {
                        System.out.println("Current card is " + x.getCard(l));
                        current = x.getCard(l);
                        x.removeCard(x.getCard(l));
                        System.out.println("Hand: " + x.getHand());
                    } else {
                        Card drew = one.deal();
                        x.addCard(drew);
                        System.out.println("Drew a " + drew);
                        break;
                    }
                }
                System.out.print("Can't discard, drawing");
                Card drew = one.deal();
                x.addCard(drew);
                System.out.println("Drew a " + drew);
                l++;
            }
            while (l < x.getHand().size() - 1);
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


