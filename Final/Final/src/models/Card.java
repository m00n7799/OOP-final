
package models;
import enums.Rank;
import enums.Suit;
public class Card {
private Rank value;
private Suit suit;
private boolean hidden;
private int cardValue;
public Card(Suit suit, Rank rank) {
	setSuit(suit);
	setValue(rank);
}
public Rank getValue() {
	return value;
}
public void setValue(Rank value) {
	this.value=value;
}
public Suit getSuit() {
	return suit;
}
public void setSuit(Suit suit) {
	this.suit=suit;
}
public boolean isHidden() {
	return hidden;
}
public void Hidden(boolean hidden) {
	this.hidden=hidden;
}
public void flip() {
	hidden = !hidden;
}
public int getCardValue() {
	return cardValue;
}
public void setCardValue(Rank value) {
	switch(value) {
	case ACE:
		this.cardValue = 1;
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
	String cardval="";
	if(!hidden) {
		cardval=getValue()+" of "+getSuit();
	}
	return cardval;
}
}
