package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;

public class Dealer extends Person {
	
	private AbstractHand hand = new BlackJackHand(); 
	
	public Dealer() {
	}

	
	
	
	public AbstractHand getHand() {
		return hand;
	}




	public void setHand(AbstractHand hand) {
		this.hand = hand;
	}




	@Override
	public String toString() {
		return "Dealer" + hand;
	}




	
	
	

}
