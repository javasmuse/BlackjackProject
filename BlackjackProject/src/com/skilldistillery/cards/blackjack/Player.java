package com.skilldistillery.cards.blackjack;

public class Player extends Person {
	private int age; 
	private BlackJackHand hand = new BlackJackHand();
	
	
	public Player(String name, int age, BlackJackHand hand) {
		super.getName(); 
		this.age = age; 
		this.hand = hand; 
	}
	
	
	public Player() {
	}

	
	public int getAge() {
		return age;
	}


	public BlackJackHand getHand() {
		return hand;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}


	@Override
	public String toString() {
		return "\nPlayer one you got " + hand;
	}


	

	
	
	

	
	
}