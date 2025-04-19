/*
 * CS342 Fall 2024
 * Burak Simsek
 * 3-Card Poker Game
 * Project #2
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ThreeCardLogicTest {

    @Test
    void testEvalHandStraightFlush() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 10));
        hand.add(new Card('H', 11));
        hand.add(new Card('H', 12));
        assertEquals(1, ThreeCardLogic.evalHand(hand), "Should be a straight flush.");
    }

    @Test
    void testEvalHandThreeOfAKind() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 8));
        hand.add(new Card('H', 8));
        hand.add(new Card('S', 8));
        assertEquals(2, ThreeCardLogic.evalHand(hand), "Should be three of a kind.");
    }

    @Test
    void testEvalHandStraight() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('S', 5));
        hand.add(new Card('D', 6));
        hand.add(new Card('H', 7));
        assertEquals(3, ThreeCardLogic.evalHand(hand), "Should be a straight.");
    }

    @Test
    void testEvalHandFlush() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('C', 2));
        hand.add(new Card('C', 9));
        hand.add(new Card('C', 13));
        assertEquals(4, ThreeCardLogic.evalHand(hand), "Should be a flush.");
    }

    @Test
    void testEvalHandPair() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 4));
        hand.add(new Card('D', 4));
        hand.add(new Card('S', 6));
        assertEquals(5, ThreeCardLogic.evalHand(hand), "Should be a pair.");
    }

    @Test
    void testEvalHandHighCard() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 3));
        hand.add(new Card('D', 5));
        hand.add(new Card('S', 9));
        assertEquals(0, ThreeCardLogic.evalHand(hand), "Should be high card.");
    }

    @Test
    void testEvalPPWinningsStraightFlush() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 10));
        hand.add(new Card('H', 11));
        hand.add(new Card('H', 12));
        int bet = 10;
        assertEquals(400, ThreeCardLogic.evalPPWinnings(hand, bet), "Should return 40 times the bet.");
    }

    @Test
    void testEvalPPWinningsThreeOfAKind() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 7));
        hand.add(new Card('H', 7));
        hand.add(new Card('S', 7));
        int bet = 10;
        assertEquals(300, ThreeCardLogic.evalPPWinnings(hand, bet), "Should return 30 times the bet.");
    }

    @Test
    void testEvalPPWinningsFlush() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('C', 5));
        hand.add(new Card('C', 8));
        hand.add(new Card('C', 13));
        int bet = 10;
        assertEquals(30, ThreeCardLogic.evalPPWinnings(hand, bet), "Should return 3 times the bet.");
    }

    @Test
    void testEvalPPWinningsHighCard() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('S', 2));
        hand.add(new Card('H', 6));
        hand.add(new Card('D', 10));
        int bet = 10;
        assertEquals(0, ThreeCardLogic.evalPPWinnings(hand, bet), "Should return 0 for high card.");
    }

   

    @Test
    void testCompareHandsPlayerWins() {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('S', 2));
        dealerHand.add(new Card('C', 3));
        dealerHand.add(new Card('H', 4));
        
        ArrayList<Card> playerHand = new ArrayList<>();
        playerHand.add(new Card('H', 10));
        playerHand.add(new Card('C', 11));
        playerHand.add(new Card('D', 12));
        
        assertEquals(2, ThreeCardLogic.compareHands(dealerHand, playerHand), "Player should win.");
    }
    

    
    @Test
    void testCompareHandsSameRankDifferentHighCard() {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('C', 10));
        dealerHand.add(new Card('D', 11));
        dealerHand.add(new Card('H', 12)); // High card is Queen

        ArrayList<Card> playerHand = new ArrayList<>();
        playerHand.add(new Card('S', 9));
        playerHand.add(new Card('C', 10));
        playerHand.add(new Card('D', 11)); // High card is Jack

        assertEquals(1, ThreeCardLogic.compareHands(dealerHand, playerHand), "Dealer should win based on high card.");
    }

    
    @Test
    void testCompareHandsTie() {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('H', 5));
        dealerHand.add(new Card('D', 7));
        dealerHand.add(new Card('S', 9));

        ArrayList<Card> playerHand = new ArrayList<>();
        playerHand.add(new Card('H', 5));
        playerHand.add(new Card('D', 7));
        playerHand.add(new Card('S', 9));

        assertEquals(0, ThreeCardLogic.compareHands(dealerHand, playerHand), "Should be a tie.");
    }

    
    @Test
    void testEvalHandLowStraight() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 2));
        hand.add(new Card('D', 3));
        hand.add(new Card('S', 4));
        assertEquals(3, ThreeCardLogic.evalHand(hand), "Should be a straight.");
    }

    
    @Test
    void testEvalHandStraightDifferentSuits() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 3));
        hand.add(new Card('S', 4));
        hand.add(new Card('D', 5));
        assertEquals(3, ThreeCardLogic.evalHand(hand), "Should be a straight with mixed suits.");
    }

    @Test
    void testEvalHandThreeOfAKindMixedSuits() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 9));
        hand.add(new Card('D', 9));
        hand.add(new Card('C', 9));
        assertEquals(2, ThreeCardLogic.evalHand(hand), "Should be three of a kind with mixed suits.");
    }

    @Test
    void testEvalHandFlushHighCardAce() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('S', 14)); // Ace
        hand.add(new Card('S', 7));
        hand.add(new Card('S', 3));
        assertEquals(4, ThreeCardLogic.evalHand(hand), "Should be a flush with a high card Ace.");
    }

    @Test
    void testEvalHandPairNonConsecutive() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 8));
        hand.add(new Card('H', 8));
        hand.add(new Card('S', 12));
        assertEquals(5, ThreeCardLogic.evalHand(hand), "Should be a pair with non-consecutive values.");
    }

    @Test
    void testEvalHandDistinctHighCard() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('C', 2));
        hand.add(new Card('D', 8));
        hand.add(new Card('S', 13)); // King
        assertEquals(0, ThreeCardLogic.evalHand(hand), "Should be high card with no other combination.");
    }

    @Test
    void testCompareHandsTieWithDifferentHighCards() {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('H', 6));
        dealerHand.add(new Card('C', 6));
        dealerHand.add(new Card('D', 10));

        ArrayList<Card> playerHand = new ArrayList<>();
        playerHand.add(new Card('S', 6));
        playerHand.add(new Card('D', 6));
        playerHand.add(new Card('H', 9));

        assertEquals(1, ThreeCardLogic.compareHands(dealerHand, playerHand), "Dealer should win due to higher kicker.");
    }

    @Test
    void testEvalHandStraightAceHigh() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 10));
        hand.add(new Card('D', 11));
        hand.add(new Card('S', 14)); // Ace as high
        assertEquals(3, ThreeCardLogic.evalHand(hand), "Should be a straight with Ace as the high card.");
    }

    @Test
    void testEvalPPWinningsLowPair() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 3));
        hand.add(new Card('H', 3));
        hand.add(new Card('S', 6));
        int bet = 5;
        assertEquals(5, ThreeCardLogic.evalPPWinnings(hand, bet), "Should return 1x bet for a pair.");
    }

    @Test
    void testCompareHandsFlushVsStraight() {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('H', 2));
        dealerHand.add(new Card('H', 5));
        dealerHand.add(new Card('H', 9)); // Flush

        ArrayList<Card> playerHand = new ArrayList<>();
        playerHand.add(new Card('D', 6));
        playerHand.add(new Card('S', 7));
        playerHand.add(new Card('C', 8)); // Straight

        assertEquals(4, ThreeCardLogic.evalHand(dealerHand), "Dealer should have a flush.");
        assertEquals(3, ThreeCardLogic.evalHand(playerHand), "Player should have a straight.");
        assertEquals(1, ThreeCardLogic.compareHands(dealerHand, playerHand), "Dealer should win with a flush over a straight.");
    }

    @Test
    void testEvalHandStraightMinimumValues() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('S', 2));
        hand.add(new Card('D', 3));
        hand.add(new Card('H', 4));
        assertEquals(3, ThreeCardLogic.evalHand(hand), "Should be a straight with minimum values.");
    }

    
}
