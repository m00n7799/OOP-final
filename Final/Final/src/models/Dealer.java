package models;

import java.util.ArrayList;

public class Dealer extends Player {

	
	String name;
	
	double myBet;
	
	public Dealer( String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	boolean doINeedTODraw() {
		if(super.getHandValue() <= 17) {
			return true;
		}
		else {
		return false;
		}
	}
	double thePayOut(ArrayList<Player> players) {
	
		double totalBet =0;
		for(Player p: players) {
			totalBet += p.myBet;
		}

		return totalBet;
		
	}
}
