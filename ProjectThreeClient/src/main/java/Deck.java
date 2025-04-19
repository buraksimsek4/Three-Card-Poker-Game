/*
 * CS342 Fall 2024
 * Burak Simsek
 * 3-Card Poker Game
 * Project #2
 */

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {

    // Constructor to create a new shuffled deck
    public Deck() {
        newDeck(); // Call the method to initialize the deck
    }

    // Method to clear the current deck and create a new set of 52 cards, then shuffle them
    public void newDeck() {
        this.clear(); // Clear any existing cards in the deck
        char[] suits = {'C', 'D', 'S', 'H'}; // Suits for clubs, diamonds, spades, hearts

        // Loop through each suit and create cards from 2 to 14 (Ace = 14)
        for (char suit : suits) {
            for (int value = 2; value <= 14; value++) {
                this.add(new Card(suit, value)); // Add new card to the deck
            }
        }
        Collections.shuffle(this); // Shuffle the deck to randomize card order
    }
}
