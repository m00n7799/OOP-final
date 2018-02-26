package models;

import java.util.ArrayList;
import java.util.Random;

import enums.Rank;
import enums.Suit;

public class Deck {
 	private ArrayList<Card> freshDeck;
	private ArrayList<Card> shuffledDeck;
	public Deck() {
		freshDeck = new ArrayList<Card>();
		shuffledDeck = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				freshDeck.add(new Card(suit,rank));
			}
		}
		shuffle();
	}
	public void shuffle() {
		Random rand=new Random();
		int gen;
		for(int i=0;i<52;i++) {
			gen=rand.nextInt(freshDeck.size());
			shuffledDeck.add(freshDeck.remove(gen));
		}
	}
}
