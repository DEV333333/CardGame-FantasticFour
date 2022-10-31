package cardgame;

public class Card {

    public static final String[] SUITS = { "Hearts", "Diamonds", "Clubs", "Spades" };

    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public Card(int i) {
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
        return value + " of " + suit;
    }
}


