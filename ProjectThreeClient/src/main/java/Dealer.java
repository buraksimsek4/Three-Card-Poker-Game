/*
 * CS342 Fall 2024
 * Burak Simsek
 * 3-Card Poker Game
 * Project #2
 */

import java.util.ArrayList;

public class Dealer {
    private Deck theDeck;
    private ArrayList<Card> dealersHand;

    public Dealer() {
        theDeck = new Deck(); // Create a new shuffled deck
        dealersHand = new ArrayList<>(); // Initialize the dealer's hand
    }

    // Method to get the deck
    public Deck getDeck() {
        return theDeck;
    }

    // Method to create a new deck (reshuffle)
    public void newDeck() {
        theDeck.newDeck();
    }

    public ArrayList<Card> dealHand() {
        ArrayList<Card> hand = new ArrayList<>();
        if (theDeck.size() < 34) {
            newDeck(); // Shuffle a new deck if fewer than 34 cards remain
        }
        for (int i = 0; i < 3; i++) {
            hand.add(theDeck.remove(0)); // Deal three cards
        }
        return hand;
    }

    public void setDealersHand(ArrayList<Card> hand) {
        this.dealersHand = hand;
    }

    public ArrayList<Card> getDealersHand() {
        return dealersHand;
    }
}
