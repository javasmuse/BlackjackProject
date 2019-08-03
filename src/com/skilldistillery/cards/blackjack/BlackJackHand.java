package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;

public class BlackJackHand extends AbstractHand {

	

	public BlackJackHand() {
		super();
	}

	
	public boolean isBlackJack() {
		 int hand = getHandValue();
		if ( hand  == 21 )
		  return true; ; 
		  return false;
		} 
	
	public boolean isBust() {
		int hand = getHandValue();
		if (hand > 21 )
			return true;
		return false; 
	}

	@Override
	public int getHandValue() {
		int total = 0;
		for (Card card : cards) {
			total += card.getValue();
		}
 		return total; 		
	}

	
	
	
	
	
}
