package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHand {
	protected List<Card> cards;

	public AbstractHand() {
		cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void clear() {
		cards.clear();

	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Card(s) " + cards + " ";
	}
//	public String toString() {
//
//		// TODO fancy display of card in hand maybe the ASCII Suit w/ number 
//		return cards.toString();

}
