package games;

import java.util.ArrayList;

import models.Card;
import models.Dealer;
import models.Deck;
import models.Human;
import models.Player;

public class BlackJack {

	static ArrayList<Player> P = new ArrayList<Player>();

	static Deck deck1 = new Deck();

	static int check;
	int count;
	static int hand2;

	public static void startNewGame(int numberOfPlayers) {

		setPlayers(numberOfPlayers);
		deck1 = new Deck();
		deck1.initialDeal(P);
	}

	public static ArrayList<Player> win() {
		ArrayList<Player> posWins = new ArrayList<Player>();
		for (Player p : P) {
			if (p.getHandValue() > 21) {
				p.setBust(true);
			}
			if (!p.isBust()) {
				posWins.add(p);
			}
		}
		for (Player player : posWins) {
			System.out.println(player.getName());
		}
		ArrayList<Player>winners= new ArrayList<>();
		int higher = 0;
		for (Player p : posWins) {
			for (Player q : posWins) {
				check = p.getHandValue();
				if (check == 21 && p.getHand().size() == 2) {
					// win
					p.setNat21(true);
					winners.add(p);
					return winners;
				} else {
					if (p.getName() != q.getName()) {
						higher = p.compareTo(q);
						if (higher == 1) {
							p.setHigher(true);
							q.setHigher(false);
						} else if (higher == -1) {
							q.setHigher(true);
							p.setHigher(false);
						} else {
							p.setHigher(false);
							q.setHigher(false);
						}
					}

				}
			}
		}
		for (Player p : posWins) {
			boolean win = true;
			boolean tie = true;
			for (Player q : posWins) {
				ArrayList<Boolean> bool = p.getHigher();
				ArrayList<Boolean> bool2 = q.getHigher();
				for (Boolean b : bool) {
					if (!b) {
						win = false;
					}
				}
				if (win) {
					p.setWin(true);
					tie = false;
					winners.add(p);
					break;
				} else {
					if (p.getName() != q.getName()) {
						for (int i = 0; i < bool.size();) {
							for (Boolean b : bool) {
								if (b != bool2.get(i)) {
									tie = false;
								}
								i++;
							}
						}
						if (tie) {
							p.setWin(true);
							q.setWin(true);
							winners.add(q);
							winners.add(p);
							break;
						}
					}
				}
			}
		}
		return winners;
	}

	public static void setPlayers(int numberOfPlayers) {
		P.clear();
		Player pl;
		for (int i = 1; i <= numberOfPlayers; i++) {
			pl = new Human("P" + i);
			P.add(pl);
		}
//		pl = new Dealer("Dealer");
//		P.add(pl);
	}

	public static ArrayList<Player> getPlayers() {
		return P;
	}

	public static Deck getDeck() {
		return deck1;
	}

	public static void startNewRound() {
		ArrayList<Card> newH=new ArrayList<>();
		for(Player p:P) {
			p.resetHand();
		}
		deck1 = new Deck();
		deck1.initialDeal(P);
		
	}
}
