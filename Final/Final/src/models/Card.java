
package models;

import enums.Rank;
import enums.Suit;
import javafx.scene.image.Image;

public class Card {
	private Rank rank;
	private Suit suit;
	private boolean isDoubled;
	private int cardValue;

	public Card(Suit suit, Rank rank) {
		setSuit(suit);
		setRank(rank);
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit2) {
		this.suit = suit2;
	}

	public int getCardValue() {
		if (isDoubled) {
			return cardValue * 2;
		} else {
			return cardValue;
		}

	}

	public void setDoubled(boolean isDoubled) {
		this.isDoubled = isDoubled;
	}

	public void setCardValue(Rank value) {
		switch (value) {
		case ACE:
			this.cardValue = 11;
			break;
		case TWO:
			this.cardValue = 2;
			break;
		case THREE:
			this.cardValue = 3;
			break;
		case FOUR:
			this.cardValue = 4;
			break;
		case FIVE:
			this.cardValue = 5;
			break;
		case SIX:
			this.cardValue = 6;
			break;
		case SEVEN:
			this.cardValue = 7;
			break;
		case EIGHT:
			this.cardValue = 8;
			break;
		case NINE:
			this.cardValue = 9;
			break;
		case TEN:
			this.cardValue = 10;
			break;
		case JACK:
			this.cardValue = 10;
			break;
		case QUEEN:
			this.cardValue = 10;
			break;
		case KING:
			this.cardValue = 10;
			break;
		default:
			break;

		}
	}

	@Override
	public String toString() {
		String cardval = "";
		String suit = getSuit().toString();
		if (suit.equals("DIAMOND")) {
			suit = "DIAMD";
		}
		cardval = getRank() + "\nof\n" + suit;
		return cardval;
	}
}
