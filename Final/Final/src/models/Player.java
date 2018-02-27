package models;

public class Player {
	private String name;
	private double balance;
	private int handValue;
	protected static boolean stand;
	
	public Player(double balance, String name, int handValue, boolean stand) {
		this.name = name;
		this.balance = balance;
		this.handValue = handValue;
		Player.stand = stand;
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
	public boolean isStand() {
		return stand;
	}
	public void setStand(boolean stand) {
		this.stand = stand;
	}
	
	
}
