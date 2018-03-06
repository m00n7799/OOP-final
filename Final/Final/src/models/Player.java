package models;

import java.util.ArrayList;

import enums.Rank;
import models.Card;

public class Player implements Comparable<Player> {

	private String name;
	private int handValue;
	double myBet;
	private boolean bust = false;
	private boolean nat21 = false;
	private ArrayList<Boolean> higher = new ArrayList<Boolean>();
	private boolean win = false;

	public boolean isBust() {
		return bust;
	}

	public void setBust(boolean bust) {
		this.bust = bust;
	}

	private ArrayList<Card> hand = new ArrayList<Card>();

	public Player(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHandValue() {
		setHandValue();
		return handValue;
	}

	public void setHandValue() {

		handValue = 0;
		for (int i = 0; i < hand.size(); i++) {
			handValue += hand.get(i).getCardValue();
		}
		if (hand.contains(Rank.ACE) && handValue > 11) {
			handValue -= 10;
		}
	}

	public void setHand(ArrayList<Card> hand2) {
		for (int i = 0; i < hand2.size(); i++) {
			hand.add(hand2.get(i));
		}
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public boolean isNat21() {
		return nat21;
	}

	public void setNat21(boolean nat21) {
		this.nat21 = nat21;
	}

	public ArrayList<Boolean> getHigher() {
		return higher;
	}

	public void setHigher(boolean higher) {
		this.higher.add(higher);
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	@Override
	public int compareTo(Player other) {
		int hand1 = this.getHandValue();
		int hand2 = other.getHandValue();
		int ret = 0;
		if (!this.isBust() && !other.isBust()) {
			if (hand1 > hand2) {
				ret = 1;
			} else if (hand2 > hand1) {
				ret = -1;
			}
		} else if (this.isBust() && !other.isBust()) {
			ret = -1;
		} else if (!this.isBust() && other.isBust()) {
			ret = 1;
		} else {
			ret = 0;
		}
		return ret;
	}
}
