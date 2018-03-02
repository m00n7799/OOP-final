package games;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import application.Controller;
import models.Deck;
import models.Player;

public class BlackJack implements Comparable<Player>{
	
	Controller controller = new Controller();
	Deck deck1 = new Deck();
	
	static ArrayList <Player> P = new ArrayList<Player>();
	
	
	int check;
	int count;
	int hand2;

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
	
	public static void setPlayers(ArrayList<Player> players) {
		
		Controller controller = new Controller();
		for (int i = 0; i < players.size(); i++) {
			P.add(players.get(i));
			System.out.println(players.get(i).getName());
			try {
				controller.setPlayer1Name(P.get(i).getName());
			}catch (Exception e){
				System.err.println("Joj");
			}
		}
	}
	
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
}
