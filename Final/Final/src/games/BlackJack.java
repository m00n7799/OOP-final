package games;

import java.util.ArrayList;

import models.Deck;
import models.Player;

public class BlackJack{
	ArrayList <Player> P = new ArrayList<Player>();
	Deck deck1 = new Deck();
	int check;
	int count;
	public void win() {
		for(int i =0; i < P.size(); i++) {
			check = P.get(i).getHandValue();
			if(check==21) {
				//win
			}else if(check<21) {
				for(int j = 0; j<P.size(); j++) {
				int hand2 =	P.get(j).getHandValue();
				int hi =P.get(check).compareTo(hand2);
				if(hi == check) {
					//win for check
				}
				if(hi==hand2) {
					//win for hand2
				}
				}
			}else if (check>21) {
				//lose
			}
		}
	}


}
