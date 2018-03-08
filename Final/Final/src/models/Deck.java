package models;

import java.util.ArrayList;
import java.util.Random;

import enums.Rank;
import enums.Suit;
import javafx.scene.image.Image;

public class Deck {

	static ArrayList<Card> freshDeck;
	static ArrayList<Card> shuffledDeck;

	public Deck() {
		newDeck();
	}

	public ArrayList<Card> getCard() {
		return shuffledDeck;
	}
	
	static void newDeck() {

//		CardSuit.suit();
		freshDeck = new ArrayList<Card>();
		shuffledDeck = new ArrayList<Card>();
		Card c = new Card(null, null);
		for (Suit suit : Suit.values()) {//CardSuit.suits
			for (Rank rank : Rank.values()) {
				c.setCardValue(rank);
				freshDeck.add(c = new Card(suit, rank));
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
				break;
			}
		}
	}

	public void initialDeal(ArrayList<Human> p) {
		for (Player player : p) {

			ArrayList<Card> hand = new ArrayList<Card>();
//			shuffledDeck.get(0).Hidden(false);
			try {
			hand.add(shuffledDeck.get(0));
			shuffledDeck.remove(0);
			}catch(IndexOutOfBoundsException ex) {
				newDeck();
			}
//			shuffledDeck.get(0).Hidden(false);
			try {
				hand.add(shuffledDeck.get(0));
				shuffledDeck.remove(0);
				}catch(IndexOutOfBoundsException ex) {
					newDeck();
				}
			player.setHand(hand);
		}
	}

	public static void nextCard(Player p) {
		ArrayList<Card> hand = new ArrayList<Card>();
//		shuffledDeck.get(0).Hidden(false);
		Card card = shuffledDeck.get(0);
		try {
			shuffledDeck.remove(0);
			hand.add(card);
			p.setHand(hand);
		} catch (NullPointerException ex) {
			newDeck();
			card = shuffledDeck.get(0);
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
