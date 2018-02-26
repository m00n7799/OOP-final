
package models;
import enums.Suit;
public class Card {
private int value;
private Suit suit;
private boolean hidden;
public int getValue() {
	return value;
}
public void setValue(int value) {
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
}
