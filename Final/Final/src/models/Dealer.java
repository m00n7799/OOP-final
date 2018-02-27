package models;

public class Dealer extends Player {

	
	String name;
	double currentMoney;
	int myValue;
	double myBet;
	
	public Dealer() {
		super();
		setName(name);
		setBalance(currentMoney);
		setHandValue(myValue);
		setBetAmount(myBet);
		
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getCurrentMoney() {
		return currentMoney;
	}


	public void setCurrentMoney(double currentMoney) {
		this.currentMoney = currentMoney;
	}


	public int getMyValue() {
		return myValue;
	}


	public void setMyValue(int myValue) {
		this.myValue = myValue;
	}


	public double getMyBet() {
		return myBet;
	}


	public void setMyBet(double myBet) {
		this.myBet = myBet;
	}


	boolean doINeedTODraw() {
		
		
		return false;
		
	}
	double thePayOut() {
	
		return 0;
		
	}
}
