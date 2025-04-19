/*
 * CS342 Fall 2024
 * Burak Simsek
 * 3-Card Poker Game
 * Project #2
 */	

import org.junit.jupiter.api.Test;
	import static org.junit.jupiter.api.Assertions.*;
	import java.util.ArrayList;
	
	public class DeckAndDealerTest {
	
	    @Test
	    void testDeckInitialization() {
	        Deck deck = new Deck();
	        assertEquals(52, deck.size(), "Deck should contain 52 cards initially.");
	    }
	
	    @Test
	    void testDeckShuffle() {
	        Deck deck1 = new Deck();
	        Deck deck2 = new Deck();
	        deck2.newDeck(); // Shuffle the second deck
	        
	        assertNotEquals(deck1, deck2, "Two shuffled decks should not be identical.");
	    }
	
	    @Test
	    void testDealHandSize() {
	        Dealer dealer = new Dealer();
	        ArrayList<Card> hand = dealer.dealHand();
	        assertEquals(3, hand.size(), "Dealt hand should contain 3 cards.");
	    }
	
	    @Test
	    void testDeckSizeAfterDealing() {
	        Dealer dealer = new Dealer();
	        dealer.dealHand();
	        assertEquals(49, dealer.getDeck().size(), "Deck should have 49 cards after one hand is dealt.");
	    }
	
	    @Test
	    void testDealerReshuffle() {
	        Dealer dealer = new Dealer();
	        for (int i = 0; i < 17; i++) {
	            dealer.dealHand(); // Deal until the deck is reshuffled
	        }
	        assertTrue(dealer.getDeck().size() > 34, "Deck should be reshuffled when it has 34 or fewer cards.");
	    }
	
	    @Test
	    void testSetDealersHand() {
	        Dealer dealer = new Dealer();
	        ArrayList<Card> hand = new ArrayList<>();
	        hand.add(new Card('H', 5));
	        hand.add(new Card('D', 10));
	        hand.add(new Card('C', 12));
	        dealer.setDealersHand(hand);
	        
	        assertEquals(hand, dealer.getDealersHand(), "Dealer's hand should be set correctly.");
	    }
	    
	    @Test
	    void testDeckHasAllSuits() {
	        Deck deck = new Deck();
	        int clubs = 0, diamonds = 0, spades = 0, hearts = 0;
	
	        for (Card card : deck) {
	            switch (card.getSuit()) {
	                case 'C': clubs++; break;
	                case 'D': diamonds++; break;
	                case 'S': spades++; break;
	                case 'H': hearts++; break;
	            }
	        }
	
	        assertEquals(13, clubs, "Deck should have 13 clubs.");
	        assertEquals(13, diamonds, "Deck should have 13 diamonds.");
	        assertEquals(13, spades, "Deck should have 13 spades.");
	        assertEquals(13, hearts, "Deck should have 13 hearts.");
	    }
	
	    @Test
	    void testCardValuesInDeck() {
	        Deck deck = new Deck();
	        boolean hasAce = false, hasTwo = false, hasKing = false;
	
	        for (Card card : deck) {
	            if (card.getValue() == 2) hasTwo = true;
	            if (card.getValue() == 14) hasAce = true; // Ace is usually represented as 14
	            if (card.getValue() == 13) hasKing = true;
	        }
	
	        assertTrue(hasTwo, "Deck should contain a card with value 2.");
	        assertTrue(hasAce, "Deck should contain an Ace (value 14).");
	        assertTrue(hasKing, "Deck should contain a King (value 13).");
	    }
	
	    @Test
	    void testDeckReshuffleIntegrity() {
	        Deck deck = new Deck();
	        deck.newDeck(); // Reshuffle the deck
	        assertEquals(52, deck.size(), "Deck should still contain 52 cards after reshuffling.");
	    }
	
	    @Test
	    void testDealHandDifferentCards() {
	        Dealer dealer = new Dealer();
	        ArrayList<Card> hand1 = dealer.dealHand();
	        ArrayList<Card> hand2 = dealer.dealHand();
	
	        assertNotEquals(hand1, hand2, "Two consecutive dealt hands should not be identical.");
	    }
	
	    @Test
	    void testDeckSizeAfterMultipleHands() {
	        Dealer dealer = new Dealer();
	        for (int i = 0; i < 5; i++) {
	            dealer.dealHand();
	        }
	        assertEquals(37, dealer.getDeck().size(), "Deck should have 37 cards after 5 hands are dealt.");
	    }
	
	    @Test
	    void testDeckRefillAfterReshuffle() {
	        Dealer dealer = new Dealer();
	        for (int i = 0; i < 17; i++) {
	            dealer.dealHand(); // Deal 17 hands to trigger reshuffle
	        }
	
	        int deckSizeAfterReshuffle = dealer.getDeck().size();
	        assertTrue(deckSizeAfterReshuffle > 34, "Deck should refill after reshuffle and contain more than 34 cards.");
	    }
	
	    @Test
	    void testSetAndRetrieveDealersHand() {
	        Dealer dealer = new Dealer();
	        ArrayList<Card> customHand = new ArrayList<>();
	        customHand.add(new Card('S', 3));
	        customHand.add(new Card('H', 7));
	        customHand.add(new Card('D', 11));
	
	        dealer.setDealersHand(customHand);
	        ArrayList<Card> retrievedHand = dealer.getDealersHand();
	
	        assertEquals(customHand, retrievedHand, "Dealer's hand should match the set hand.");
	    }
	
	    @Test
	    void testDeckOrderAfterReshuffle() {
	        Deck deck = new Deck();
	        ArrayList<Card> originalDeck = new ArrayList<>(deck);
	
	        deck.newDeck(); // Shuffle the deck
	        assertNotEquals(originalDeck, deck, "Deck order should change after reshuffling.");
	    }
	    

        @Test
        void testDeckContainsUniqueCards() {
            Deck deck = new Deck();
            ArrayList<String> seenCards = new ArrayList<>();
            
            for (Card card : deck) {
                String cardString = card.getSuit() + String.valueOf(card.getValue());
                assertFalse(seenCards.contains(cardString), "Deck should not contain duplicate cards.");
                seenCards.add(cardString);
            }
        }

        @Test
        void testDeckSizeAfterMultipleReshuffles() {
            Deck deck = new Deck();
            for (int i = 0; i < 3; i++) {
                deck.newDeck(); // Reshuffle the deck multiple times
            }
            assertEquals(52, deck.size(), "Deck should still contain 52 cards after multiple reshuffles.");
        }

        @Test
        void testCardRemovalReducesDeckSize() {
            Deck deck = new Deck();
            Card removedCard = deck.remove(0);
            assertEquals(51, deck.size(), "Deck size should decrease by 1 after a card is removed.");
            assertFalse(deck.contains(removedCard), "Removed card should not be present in the deck.");
        }

        @Test
        void testDealHandRemovesCardsFromDeck() {
            Dealer dealer = new Dealer();
            int initialSize = dealer.getDeck().size();
            ArrayList<Card> hand = dealer.dealHand();
            assertEquals(initialSize - 3, dealer.getDeck().size(), "Dealing a hand should remove 3 cards from the deck.");
            assertTrue(dealer.getDeck().size() >= 49, "Deck size should be at least 49 after dealing one hand.");
        }

        @Test
        void testDeckIntegrityAfterDealingHands() {
            Dealer dealer = new Dealer();
            dealer.dealHand();
            ArrayList<Card> remainingDeck = dealer.getDeck();
            ArrayList<Card> uniqueCards = new ArrayList<>();

            for (Card card : remainingDeck) {
                assertFalse(uniqueCards.contains(card), "Deck should not have duplicate cards.");
                uniqueCards.add(card);
            }
        }

        @Test
        void testDeckNotEmptyAfterDealing() {
            Dealer dealer = new Dealer();
            for (int i = 0; i < 16; i++) {
                dealer.dealHand(); // Deal multiple hands to reduce deck size
            }
            assertTrue(dealer.getDeck().size() > 0, "Deck should not be empty after dealing 16 hands.");
        }

        @Test
        void testDeckReshuffleBehavior() {
            Dealer dealer = new Dealer();
            for (int i = 0; i < 18; i++) {
                dealer.dealHand(); // Trigger deck reshuffle after many hands are dealt
            }
            assertTrue(dealer.getDeck().size() > 34, "Deck should be reshuffled, refilling to more than 34 cards.");
        }

        @Test
        void testDealerHandIsNotNull() {
            Dealer dealer = new Dealer();
            ArrayList<Card> dealtHand = dealer.dealHand();
            assertNotNull(dealtHand, "Dealt hand should not be null.");
        }

        @Test
        void testDealerHandDifferentFromDeck() {
            Dealer dealer = new Dealer();
            ArrayList<Card> dealtHand = dealer.dealHand();
            for (Card card : dealtHand) {
                assertFalse(dealer.getDeck().contains(card), "Dealt cards should not be present in the remaining deck.");
            }
        }

        @Test
        void testDeckReinitializationIntegrity() {
            Deck deck = new Deck();
            deck.newDeck(); // Reinitialize the deck
            assertEquals(52, deck.size(), "Deck should have 52 cards after reinitialization.");
            assertDoesNotThrow(() -> {
                for (Card card : deck) {
                    assertNotNull(card, "Each card in the deck should not be null.");
                }
            }, "Deck should not contain any null cards.");
        }
        
    }
    


