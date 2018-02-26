package models;

public class Player {
	private String name;
	private double balance;
	private int handValue;
	private double betAmount;
	private boolean stand;
	
	
	
	public Player() {
		this.name = name;
		this.balance = balance;
		this.handValue = handValue;
		this.betAmount = betAmount;
		this.stand = stand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getHandValue() {
		return handValue;
	}
	public void setHandValue(int handValue) {
		this.handValue = handValue;
	}
	public double getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}
	public boolean isStand() {
		return stand;
	}
	public void setStand(boolean stand) {
		this.stand = stand;
	}
	
	
}
