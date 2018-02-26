
package models;
import enums.Rank;
import enums.Suit;
public class Card {
private Rank value;
private Suit suit;
private boolean hidden;
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
@Override
public String toString() {
	String cardval="";
	if(!hidden) {
		cardval=getValue()+" of "+getSuit();
	}
	return cardval;
}
}
