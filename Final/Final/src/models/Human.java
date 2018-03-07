package models;

public class Human extends Player {
	String name;
	private double balance = 1500.00;
	
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
	
}
