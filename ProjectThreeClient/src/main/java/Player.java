/*
 * CS342 Fall 2024
 * Burak Simsek
 * 3-Card Poker Game
 * Project #2
 */

import java.util.ArrayList;

public class Player {
    // Data members for the player's hand, bets, and total winnings
    private ArrayList<Card> hand;
    private int anteBet;
    private int playBet;
    private int pairPlusBet;
    private int totalWinnings;
    private boolean folded; // Indicates whether the player has folded

    // Constructor to initialize the player
    public Player() {
        hand = new ArrayList<>();
        anteBet = 0;
        playBet = 0;
        pairPlusBet = 0;
        totalWinnings = 0;
        folded = false; // Initialize folded status as false
    }

    // Getter and setter methods for the player's attributes
    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getAnteBet() {
        return anteBet;
    }

    public void setAnteBet(int anteBet) {
        this.anteBet = anteBet;
    }

    
    public int getPlayBet() {
        return playBet;
    }

    public void setPlayBet(int playBet) {
        this.playBet = playBet;
    }

    public int getPairPlusBet() {
        return pairPlusBet;
    }

    public void setPairPlusBet(int pairPlusBet) {
        this.pairPlusBet = pairPlusBet;
    }

    public int getTotalWinnings() {
        return totalWinnings;
    }

    public void updateTotalWinnings(int amount) {
        this.totalWinnings += amount;
    }
    
    public void setTotalWinnings(int totalWinnings) {
        this.totalWinnings = totalWinnings;
    }

    // Method to check if the player has folded
    public boolean hasFolded() {
        return folded;
    }

    // Method to set the folded status
    public void setFolded(boolean folded) {
        this.folded = folded;
    }

    // Method to reset player's bets and hand
    public void resetPlayer() {
        hand.clear();
        anteBet = 0;
        playBet = 0;
        pairPlusBet = 0;
        folded = false;
    }

    // toString method for displaying the player's hand and total winnings
    @Override
    public String toString() {
        return "Hand: " + hand + ", Total Winnings: $" + totalWinnings;
    }
}
