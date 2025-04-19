/*
 * CS342 Fall 2024
 * Burak Simsek
 * 3-Card Poker Game
 * Project #2
 */

import java.util.ArrayList;
import java.util.Collections;

public class ThreeCardLogic {

    // Method to evaluate the value of a given hand
    public static int evalHand(ArrayList<Card> hand) {
        // Sort the hand by value to facilitate straight and flush checks
        Collections.sort(hand, (c1, c2) -> c1.getValue() - c2.getValue());

        boolean isFlush = hand.get(0).getSuit() == hand.get(1).getSuit() &&
                          hand.get(1).getSuit() == hand.get(2).getSuit();
        
        boolean isStraight = (hand.get(0).getValue() + 1 == hand.get(1).getValue() &&
                              hand.get(1).getValue() + 1 == hand.get(2).getValue()) ||
                             (hand.get(0).getValue() == 10 && hand.get(1).getValue() == 11 &&
                              hand.get(2).getValue() == 14); // Ace as high in 10-J-Q-K-A

        if (isFlush && isStraight) {
            return 1; // Straight flush
        } else if (hand.get(0).getValue() == hand.get(1).getValue() &&
                   hand.get(1).getValue() == hand.get(2).getValue()) {
            return 2; // Three of a kind
        } else if (isStraight) {
            return 3; // Straight
        } else if (isFlush) {
            return 4; // Flush
        } else if (hand.get(0).getValue() == hand.get(1).getValue() ||
                   hand.get(1).getValue() == hand.get(2).getValue() ||
                   hand.get(0).getValue() == hand.get(2).getValue()) {
            return 5; // Pair
        } else {
            return 0; // High card
        }
    }

    // Method to evaluate Pair Plus winnings for a given hand and bet
    public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
        int handValue = evalHand(hand);
        switch (handValue) {
            case 1: return bet * 40; // Straight flush
            case 2: return bet * 30; // Three of a kind
            case 3: return bet * 6;  // Straight
            case 4: return bet * 3;  // Flush
            case 5: return bet;      // Pair
            default: return 0;       // High card, no winnings
        }
    }

    // Method to compare two hands: dealer and player
    public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
        int dealerValue = evalHand(dealer);
        int playerValue = evalHand(player);

        if (dealerValue == playerValue) {
            // Compare by highest card (kicker) if hand types are the same
            for (int i = 2; i >= 0; i--) {
                if (dealer.get(i).getValue() > player.get(i).getValue()) {
                    return 1; // Dealer wins by kicker
                } else if (dealer.get(i).getValue() < player.get(i).getValue()) {
                    return 2; // Player wins by kicker
                }
            }
            return 0; // Tie if all card values are the same
        }

        return dealerValue > playerValue ? 1 : 2; // Return 1 if dealer wins, 2 if player wins
    }
}
