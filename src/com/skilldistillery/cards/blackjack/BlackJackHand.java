package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;

public class BlackJackHand extends AbstractHand {
	

	public int getHandValue(int points) { // for loop 
		
 		return 0; 
	}
	
	public boolean isBlackJack() {
		 int hand = 0;
		if ( hand  == 21 )
		  return true; ; 
		  return false;
		} 
	
	public boolean isBust() {
		int hand = 0;
		if (hand > 21 )
			return true;
		return false; 
	}

	@Override
	public int getHandValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
