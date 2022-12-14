/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softwareproject;

/**
 *
 * @author Hriday Juneja
 * @author Lovepreet Kaur
 * @author Nikhil Chaudhary
 * @author Harsh Patel
 */

public class Card {

    public static final String[] SUITS = { "Hearts", "Diamonds", "Clubs", "Spades" };

    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public int getid (int id) {
        return id;
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
        return value + " of " + suit;
    }
}


    public String getSuit() {
        return suit;
    }

    public String toString() {
        return value + " of " + suit;
    }
}
