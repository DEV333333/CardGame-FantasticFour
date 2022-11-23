/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softwareproject;

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
                        System.out.println("Are you ready to play? (y/n)");
                        String answer = input.nextLine();
                        if (answer.equalsIgnoreCase("y")) {
                                System.out.println("How many players are there?");
                                int numPlayers = input.nextInt();
                                Player[] players = new Player[numPlayers];
                                for (int i = 0; i < numPlayers; i++) {
                                        boolean validName = false;
                                        while (!validName) {
                                                System.out.println("Enter the name of player " + (i + 1));
                                                String name = input.next();
                                                if (name.matches("[a-zA-Z]+")) {
                                                        validName = true;
                                                        for (int j = 0; j < i; j++) {
                                                                if (players[j].getName().equals(name)) {
                                                                        System.out.println("That name is already taken. Please enter a new name.");
                                                                        validName = false;
                                                                }
                                                        }
                                                        if (validName) {
                                                                players[i] = new Player(name);
                                                        }
                                                } else {
                                                        System.out.println("Please enter a valid name.");
                                                }
                                        }
                                        System.out.println("Hello " + players[i].getName() + "!");
                                        System.out.println("You have " + players[i].getScore() + " points right now");
                                }
                                System.out.println("How many rounds should be played?");
                                int numRounds = input.nextInt();
                                Card[] hand = new Card[8];
                                Random random = new Random();
                                for (int i = 0; i < hand.length; i++) {
                                        int value = random.nextInt(13) + 1;
                                        String suit = Card.SUITS[random.nextInt(4)];
                                        Card card = new Card(value, suit);
                                        hand[i] = card;
                                }
                                for (int i = 0; i < numRounds; i++) {
                                        System.out.println("Round " + (i + 1) + "!");
                                        for (int k = 0; k < numPlayers; k++) {
                                                System.out.println("Player " + players[k].getName() + ": ");
                                                System.out.println("Here are the cards in the hand");
                                                for (Card card : hand) {
                                                        System.out.printf("%d of %s\n", card.getValue(),
                                                                        card.getSuit());
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
                                                                System.out.println(
                                                                                player.getName() + " is the winner!");
                                                        }
                                                }
                                        } else {
                                                System.out.print("There was a tie between ");
                                                for (Player player : players) {
                                                        if (player.getScore() == maxScore) {
                                                                System.out.print(player.getName() + " ");
                                                        }
                                                }
                                                System.out.println();
                                                System.out.print("Thank you for playing!");
                                        }

                                }
                        } else if (answer.equalsIgnoreCase("n")) {
                                System.out.println("Goodbye!");
                        } else {
                                System.out.println("Invalid input");
                        }
                }
        }
}
