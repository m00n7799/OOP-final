package models;

import java.util.ArrayList;

import enums.Rank;
import models.Card;

public class Player {
	
	private String name;
	private int handValue;
	double myBet;

	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHandValue() {
		return handValue;
	}
	
	public void setHandValue() {
		for(int i = 0; i < hand.size(); i++ ) {
			this.handValue += hand.get(i).getCardValue();
		}
		if(hand.contains(Rank.ACE) && handValue > 11) {
			handValue -= 10;
		}
	}

	public void setHand(ArrayList<Card> hand2) {
		for(int i=0;i<hand2.size();i++) {
		hand.add(hand2.get(i));
		}
	}
	public ArrayList<Card> getHand(){
		return hand;
	}
	
}
