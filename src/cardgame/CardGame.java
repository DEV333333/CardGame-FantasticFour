package cardgame;

import java.util.Random;
import java.util.Scanner;
/**
 * This class models a simple card guessing game
 * 
 * @author Hriday Juneja
 * @author Lovepreet Kaur
 * @author Nikhil Chaudhary
 * @author Harsh Patel
 */
public class CardGame {
        public static void main(String[] args) {
                try (Scanner input = new Scanner(System.in)) {
                        System.out.println("Welcome to the card game!");
                        System.out.println("How many players are there?");
                        int numPlayers = input.nextInt();
                        Player[] players = new Player[numPlayers];
                        for (int i = 0; i < numPlayers; i++) {
                                System.out.println("What is the name of player " + (i + 1) + "?");
                                String name = input.next();
                                players[i] = new Player(name);
                        }
                        System.out.println("How many rounds should be played?");
                        int numRounds = input.nextInt();
                        Card[] hand = new Card[7];
                        Random random = new Random();
                        for (int i = 0; i < hand.length; i++) {
                                int value = random.nextInt(13) + 1;
                                String suit = Card.SUITS[random.nextInt(4)];
                                Card card = new Card(value, suit);
                                hand[i] = card;
                        }
                        // Take the input from each player
                        for (int i = 0; i < numRounds; i++) {
                                System.out.println("Round " + (i + 1) + "!");
                                for (int k = 0; k < numPlayers; k++) {
                                        System.out.println("Player " + players[k].getName() + ": ");
                                        System.out.println("Here are the cards in the hand");
                                        for (Card card : hand) {
                                                System.out.printf("%d of %s\n", card.getValue(), card.getSuit());
                                        }
                                        System.out.println("Pick a suit for your card");
                                        for (int j = 0; j < Card.SUITS.length; j++) {
                                                System.out.println((j + 1) + ": " + Card.SUITS[j]);
                                        }
                                        int suit = input.nextInt();
                                        System.out.println("Enter a value (1 to 13)");
                                        int value = input.nextInt();
                                        Card userGuess = new Card(value, Card.SUITS[suit - 1]);
                                        boolean match = false;
                                        for (Card card : hand) {
                                                if (card.getValue() == userGuess.getValue()
                                                                && card.getSuit().equals(userGuess.getSuit())) {
                                                        match = true;
                                                        break;
                                                }
                                        }
                                        if (match) {
                                                System.out.println("It was a match!");
                                                players[i].setScore(players[i].getScore() + 1);
                                                if (players[i].getScore() == 3) {
                                                        players[i].setWinner(true);
                                                }
                                        } else {
                                                System.out.println("No match");
                                        }
                                        System.out.println("Here are the scores:");
                                        for (Player player : players) {
                                                System.out.println(player.getName() + ": " + player.getScore());
                                        }
                                }
                                int maxScore = 0;
                                for (Player player : players) {
                                        if (player.getScore() > maxScore) {
                                                maxScore = player.getScore();
                                        }
                                }
                                int numWinners = 0;
                                for (Player player : players) {
                                        if (player.getScore() == maxScore) {
                                                numWinners++;
                                        }
                                }
                                if (numWinners == 1) {
                                        for (Player player : players) {
                                                if (player.getScore() == maxScore) {
                                                        System.out.println(player.getName() + " is the winner!");
                                                }
                                        }
                                } else {
                                        System.out.print("It was a tie between ");
                                        for (Player player : players) {
                                                if (player.getScore() == maxScore) {
                                                        System.out.print(player.getName() + " ");
                                                }
                                        }
                                        System.out.println();
                                }

                        }
                }
        }
}