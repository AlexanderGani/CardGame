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
        System.out.println("Player 1, what is your name?");
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
        //allow user to pick card
        while(!o.getHand().isEmpty() && !x.getHand().isEmpty()) {
            //one needs to be presented options
            System.out.println(o.getName() + "'s turn: ");
            for (int m = 0; m < o.getHand().size(); m++) {
                System.out.println(o.getHand());
                System.out.println("Select Card to Play (by index, starting at 0) or Draw a Card (-1): ");
                int input = scan.nextInt();
                if (input == -1) {
                    Card draw = one.deal();
                    System.out.println("Drawing...\n Drew a " + draw);
                    o.addCard(draw);
                    break;
                } else if (current.getSuit().equals(o.getCard(input).getSuit())
                        || current.getRank().equals(o.getCard(input).getRank()) || o.getCard(input).getRank().equals("8")) {
                    current = o.getCard(input);
                    o.removeCard(o.getCard(input));
                    System.out.println("Played a " + current);
                    System.out.println(" Current card is a " + current);
                } else {
                    System.out.println("Invalid Input: Select other card");
                }
            }

            //two needs to be presented options
            System.out.println(x.getName() + "'s turn: ");
            if(!x.getName().equals("Computer")) {
                for (int l = 0; l < x.getHand().size(); l++) {
                    System.out.println(x.getHand());
                    System.out.println("Select Card to Play (by index, starting at 0) or Draw a Card (-1): ");
                    int input = scan.nextInt();
                    if (input == -1) {
                        Card draw = one.deal();
                        System.out.println("Drawing...\n Drew a " + draw);
                        x.addCard(draw);
                        break;
                    } else if (current.getSuit().equals(x.getCard(input).getSuit())
                            || current.getRank().equals(x.getCard(input).getRank()) || x.getCard(input).getRank().equals("8")) {
                        current = x.getCard(input);
                        x.removeCard(x.getCard(input));
                        System.out.println("Played a " + current);
                        System.out.println(" Current card is a " + current);
                    } else {
                        System.out.println("Invalid Input: Select other card");
                    }
                }
            }
            else {
                    for (int l = 0; l < x.getHand().size(); l++) {
                        int input = 0;
                        System.out.println("Computer Hand: " + x.getHand());
                        if(!current.getSuit().equals(x.getCard(l).getSuit())
                                && current.getRank().equals(x.getCard(l).getRank()) && !x.getCard(l).getRank().equals("8")) {
                            input = -1;
                        }
                        if (input == -1) {
                            Card draw = one.deal();
                            System.out.println("Drawing...\n Computer drew a " + draw);
                            x.addCard(draw);
                            break;
                        } else {
                            current = x.getCard(input);
                            x.removeCard(x.getCard(input));
                            System.out.println("Computer played a " + current);
                            System.out.println(" Current card is a " + current);
                        }
                    }
            }
            if(o.getHand().isEmpty() && x.getHand().isEmpty()) {
                System.out.println("It's a draw");
            }

            else if (o.getHand().isEmpty()) {
                win(o);
            }

            else if (x.getHand().isEmpty()) {
                win(x);
            }
        }
    }
}


