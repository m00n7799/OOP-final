package models;

import java.util.ArrayList;
import models.Card;
public class Player {
	private String name;
	private double balance = 1500.00;
	private double currentBalance = 0;
	private int handValue;
	

	
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player(double currentBalance, double balance, String name, int handValue) {
		this.name = name;
		this.balance = balance;
		this.handValue = handValue;
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
		this.currentBalance += balance;
		this.currentBalance = currentBalance;
		
	}
	public int getHandValue() {
		return handValue;
	}
	public void setHandValue() {
		for(int i = 0; i < hand.size(); i++ ) {
			this.handValue += hand.get(i).getCardValue();
		}
		
	}
	
	
}
