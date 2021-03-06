package models;

import java.util.ArrayList;
import java.util.Random;

import enums.Rank;
import enums.Suit;

public class Deck {

	static ArrayList<Card> freshDeck;
	static ArrayList<Card> shuffledDeck;

	public Deck() {
		newDeck();
	}

	static public ArrayList<Card> getCard() {

		return shuffledDeck;
	}

	static void newDeck() {

		// CardSuit.suit();
		freshDeck = new ArrayList<Card>();
		shuffledDeck = new ArrayList<Card>();
		Card c = new Card(null, null);
		for (Suit suit : Suit.values()) {// CardSuit.suits
			for (Rank rank : Rank.values()) {
				freshDeck.add(c = new Card(suit, rank));
				c.setCardValue(rank);
			}
		}
		shuffle();
	}

	public static void shuffle() {
		Random rand = new Random();
		int gen;
		for (int i = 0; i < 52; i++) {
			gen = rand.nextInt(freshDeck.size());
			try {
				shuffledDeck.add(freshDeck.remove(gen));
			} catch (NullPointerException ex) {
				new Deck();
				shuffledDeck.add(freshDeck.remove(gen));
				break;
			}
		}
	}

	public void initialDeal(ArrayList<Human> p) {
		for (Player player : p) {

			ArrayList<Card> hand = new ArrayList<Card>();
			// shuffledDeck.get(0).Hidden(false);
			try {
				hand.add(shuffledDeck.get(0));
				shuffledDeck.remove(0);
			} catch (IndexOutOfBoundsException ex) {
				newDeck();
				hand.add(shuffledDeck.get(0));
				shuffledDeck.remove(0);
			}
			catch (NullPointerException e) {
				newDeck();
				hand.add(shuffledDeck.get(0));
				shuffledDeck.remove(0);
			}
			// shuffledDeck.get(0).Hidden(false);
			try {
				hand.add(shuffledDeck.get(0));
				shuffledDeck.remove(0);
			} catch (IndexOutOfBoundsException ex) {
				newDeck();
				hand.add(shuffledDeck.get(0));
				shuffledDeck.remove(0);
			}catch (NullPointerException e) {
				newDeck();
				hand.add(shuffledDeck.get(0));
				shuffledDeck.remove(0);
			}
			player.setHand(hand);
		}
	}

	public static void nextCard(Player p, boolean isDouble) {
		ArrayList<Card> hand = new ArrayList<Card>();
		// shuffledDeck.get(0).Hidden(false);
		Card card = null;
		
		try {
			card=shuffledDeck.get(0);
			if(isDouble) {
				card.setDoubled(true);
			}
			shuffledDeck.remove(0);
			hand.add(card);
			p.setHand(hand);
		} catch (NullPointerException ex) {
			newDeck();
			card = shuffledDeck.get(0);
			if(isDouble) {
				card.setDoubled(true);
			}
			hand.add(card);
			p.setHand(hand);
		}catch (IndexOutOfBoundsException e) {
			newDeck();
			card = shuffledDeck.get(0);
			if(isDouble) {
				card.setDoubled(true);
			}
			hand.add(card);
			p.setHand(hand);
		}
	}

	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		for (Card card : shuffledDeck) {
			build.append(card.toString()).append("\n");
		}
		return build.toString();
	}
}
