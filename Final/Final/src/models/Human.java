package models;

public class Human extends Player {
	String name;
	private double balance = 1500.00;
	private double currentBalance = 0;

	public Human( String name) {
		super(name);
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
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = balance + currentBalance;
		
	}
}
