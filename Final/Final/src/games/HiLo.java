package games;

import models.Deck;

public class HiLo {
	boolean contuine = true;
	int anti = 1500;

	public void game(boolean bool) {
		
			
//			play a card and display it
//			let the player choose if it is higher or
//			lower then the next card
//			
			//make sure to ask every time after a card if
			//they'd like to quit
			
			if(bool == true) {
				anti += 100;
				win();
			}else {
				if(bool==false) {
					anti-= 100;
					lose();
				}
			}
		}

	public void lose() {
		if (anti == -50) {
			// lose
		} else {
			// ask if they'd like to quit
		}
	}

	public void win() {
		if (contuine == false) {
			// win sorta
		} else {

		}
	}
}
