package models;
public class Dealer extends Player {

	
	String name;
	double currentMoney;
	int myValue;
	double myBet;
	
	public Dealer(double balance, String name,  int handValue) {
		super(balance, name, handValue);
		// TODO Auto-generated constructor stub
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


	boolean doINeedTODraw() {
		if(myValue <= 17) {
			return true;
		}
		else {
		return false;
		}
	}
	double thePayOut() {
	
		return 0;
		
	}
}
