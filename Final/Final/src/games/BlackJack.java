package games;

import java.util.ArrayList;
import models.Deck;
import models.Player;

public class BlackJack implements Comparable<Player> {

	static ArrayList<Player> P = new ArrayList<Player>();

	Deck deck1 = new Deck();

	int check;
	int count;
	int hand2;

	public void win() {
		for (int i = 0; i < P.size(); i++) {
			check = P.get(i).getHandValue();
			if (check == 21) {
				// win
			} else if (check < 21) {
				int whoWon = compareTo(P.get(i));
				if (whoWon == check) {
					// check won
				}
				if (whoWon != check) {
					// other person won
				} else {
					// no one won Tie
				}

			} else if (check > 21) {
				// lose
			}
		}
	}

	public static void setPlayers(int howmany) {
		P.clear();
		Player pl;
		for (int i = 1; i <= howmany; i++) {
			pl = new Player("P" + i);
			P.add(pl);
		}
	}

	public static ArrayList<Player> getPlayers() {
		return P;
	}

	@Override
	public int compareTo(Player arg0) {
		int hand1 = check;
		hand2 = arg0.getHandValue();
		for (int j = 0; j < P.size(); j++) {
			if (P.get(j).getName() == arg0.getName()) {
				// return same player
			}
		}
		if (hand1 > hand2) {
			return hand1;
		}
		if (hand2 > hand1) {
			return hand2;
		}
		if (hand1 == hand2) {
			return 0;
		} else {
			return 0;
		}

	}

}
