/*
 * CS342 Fall 2024
 * Burak Simsek
 * 3-Card Poker Game
 * Project #2
 */

public class Card {
    // Data members to represent the suit and value of a card
    private char suit; // 'C', 'D', 'S', 'H' for clubs, diamonds, spades, hearts
    private int value; // Integer value from 2 to 14 (Ace = 14, King = 13, etc.)

    // Constructor to initialize the card's suit and value
    public Card(char suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    // Getter for the suit
    public char getSuit() {
        return suit;
    }

    // Getter for the value
    public int getValue() {
        return value;
    }

    // toString method to represent the card as a string (e.g., "10_H" for 10 of Hearts)
    @Override
    public String toString() {
        return value + "_" + suit;
    }
}
