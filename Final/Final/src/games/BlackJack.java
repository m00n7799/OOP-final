package games;

import java.util.ArrayList;

import models.Dealer;
import models.Deck;
import models.Human;

public class BlackJack {

	static ArrayList<Human> P = new ArrayList<>();
	static ArrayList<Dealer> dealer = new ArrayList<>();
	static Deck deck1 = new Deck();

	static int check;
	int count;
	static int hand2;

	public static void startNewGame(int numberOfPlayers) {

		setPlayers(numberOfPlayers);
		deck1 = new Deck();
		deck1.initialDeal(P);
	}

	public static ArrayList<Human> win() {

		ArrayList<Human> posWinners = new ArrayList<>();
		ArrayList<Human> winners = new ArrayList<>();

		for (Human p : P) {
			if (!p.isBust()) {
				posWinners.add(p);
			}
		}

		for (Human player : posWinners) {
			if (player.isNat21()) {
				winners.add(player);
			}
		}

		if (!winners.isEmpty()) {
			return winners;			
		}
		
		int higher = 0;
		for (Human p : posWinners) {
			for (Human q : posWinners) {
				check = p.getHandValue();
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
		for (Human p : posWinners) {
			boolean win = true;
			boolean tie = true;
			for (Human q : posWinners) {
				ArrayList<Boolean> bool = p.getHigher();
				for (Boolean b : bool) {
					if (!b) {
						win = false;
					}
				}
				if (win) {
					p.setWin(true);
					tie = false;
					winners.add(p);
					return winners;
				} else {
					if (p.getName() != q.getName()) {
						if (p.getHandValue() != q.getHandValue()) {
							tie = false;
						}
						if (tie) {
							p.setWin(true);
							q.setWin(true);
							winners.add(p);
						}
					}
				}
			}
		}
		return winners;
	}

	public static void setPlayers(int numberOfPlayers) {
		P.clear();
		Human pl;
		for (int i = 1; i <= numberOfPlayers; i++) {
			pl = new Human("P" + i);
			P.add(pl);
		}
	}

	public static ArrayList<Human> getPlayers() {
		return P;
	}

	public static Deck getDeck() {
		return deck1;
	}
	
	public static void dealerInitialDeal(Dealer dealer) {
		Deck.nextCard(dealer, false);
		Deck.nextCard(dealer, false);
	}
	
	public static void dealerDraw(Dealer dealer) {
		Deck.nextCard(dealer, false);
	}

	public static void startNewRound(Dealer dealer) {

		for (Human p : P) {
			p.resetHand();
		}
		
		dealer.resetHand();

		try {
			deck1.initialDeal(P);
		} catch (NullPointerException ex) {
			deck1 = new Deck();
			deck1.initialDeal(P);
		} catch (IndexOutOfBoundsException e) {
			deck1 = new Deck();
			deck1.initialDeal(P);
		}
	}
}
