package games;

import models.Deck;

public class HiLo {
	boolean isHigher = false;
	boolean isLower = false;
	boolean contuine = false;
	int anti = 1500;
	static Deck deck = new Deck();
	public void game() {
		for(int i =0; i < deck.toString().length(); i++) {
//			play a card and display it
//			let the player choose if it is higher or
//			lower then the next card
//			
			//make sure to ask every time after a card if
			//they'd like to quit
			
			if(isHigher == true) {
				anti += deck.toString().charAt(i);
				win();
			}else if(isLower==true) {
				anti += deck.toString().charAt(i);
				win();
			}else {
				if(isHigher==false) {
					anti-= deck.toString().charAt(i);
					lose();
				}else if(isLower==false) {
					anti-= deck.toString().charAt(i);
					lose();
				}
			}
		}
	}
	public void lose() {
		if(anti==-50) {
			//lose
		}else {
			//ask if they'd like to quit
		}
	}
	public void win() {
		if(contuine==false) {
			//win sorta
		}else {
			
		}
	}
}
