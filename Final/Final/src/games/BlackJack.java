package games;

import java.util.ArrayList;
import models.Deck;
import models.Player;

<<<<<<< HEAD
public class BlackJack{
	
	static ArrayList <Player> P = new ArrayList<Player>();
	Deck deck1 = new Deck();
	int check;
	int count;
	
=======
public class BlackJack implements Comparable<Player>{
	ArrayList <Player> P = new ArrayList<Player>();
	Deck deck1 = new Deck();
	int check;
	int count;
	int hand2;
>>>>>>> 2ebe5c16c407b97aff650171d677a22b08a8d909
	public void win() {
		for(int i =0; i < P.size(); i++) {
			check = P.get(i).getHandValue();
			if(check==21) {
				//win
			}else if(check<21) {
				compareTo(P.get(i));
			}else if (check>21) {
				//lose
			}
		}
	}
<<<<<<< HEAD
	
	public static void setPlayers(ArrayList<Player> players) {
		for (int i = 0; i < players.size(); i++) {
			P.add(players.get(i));
		}
	}
=======
	@Override
	public int compareTo(Player arg0) {
		int hand1 = check;
		hand2 =arg0.getHandValue();
		for(int j = 0; j<P.size(); j++) {
		if(P.get(j).getName() == arg0.getName()) {
			//return same player
		}
		}
		if(hand1 > hand2) {
			return hand1;
		}
		if(hand2 > hand1) {
			return hand2;
		}
		if(hand1==hand2) {
			return 0;
		}else {
			return 0;
		}
		
	}


>>>>>>> 2ebe5c16c407b97aff650171d677a22b08a8d909
}
