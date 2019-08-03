package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Rank;

public class BlackJackTable {

	Scanner kb = new Scanner(System.in);

	Player one = new Player();
	Dealer bob = new Dealer();

	String input;
	private boolean keepPlaying = true;

	public void welcome() {

//		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to the Beau Rivage BlackJack Table"); // maybe insert some ascii cards
		System.out.println("What's your name?");
		input = kb.next();
		System.out.println("How old are ya kid?");
		int age = kb.nextInt();
		if (age < 21) {
			System.out.println("Sorry kid the video games are across the street.");
			keepPlaying = false;
		}
		System.out.println("Hello, " + input + " Have a seat.");
		Player you = new Player(input, 31);
		you.toString();
		deal();

	}

	public void deal() {
		Deck deck = new Deck();
		deck.shuffleCard(); 
		one.getHand().addCard(deck.dealCard()); 
		System.out.println(one.toString());
		bob.getHand().addCard(deck.dealCard());
		System.out.println(Rank.values()); 
		
		one.getHand().addCard(deck.dealCard()); 
		System.out.println(one.toString());
		
		 // add players hand up 
		// check for 21 or bust
		
		System.out.println(bob.toString());
//		keepPlaying = false; 
		
		System.out.println("Interesting cards mate, wanna hit? \n Press 1 to hit or 2 to stay.");
		int choice = kb.nextInt(); 
			switch (choice) {
			case 1: 
				one.getHand().addCard(deck.dealCard()); 
				System.out.println(one.toString());	
				break;
			case 2:
				System.out.println(bob.toString());
				break;
				
			}
		
		bob.getHand().addCard(deck.dealCard());
	}
	
}
		
		
		
		

		// check deck if remaining number < 20 then shuffle
		// player gets card, show value
		// dealer gets card, hide value
		// player gets card, show value
		// dealer gets card, show value
		// add value and call getHand from BlackJackHand - check for bust or BlackJack
		// for dealer also
		// if blackjack - Yay
		// but if player hand and dealer hand both = black jack, push, at least no money
		// lost -- call dealAgain();
		// ask player hit ?
		// if yes -- add a card
		// if no
		// check dealers cards use rules for dealer hand

//	}

//	    System.out.print("How many cards: ");
//	    
//	    try {
//	      int numCards = sc.nextInt();
//	      if(numCards > 52) {
//	        throw new InputMismatchException();
//	      }
//	      
//	      List<Card> hand = new ArrayList<>(numCards);
//	      int totalValue = 0;
//	      for(int i = 0; i < numCards; i++) {
//	        Card c = deck.dealCard();
//	        totalValue += c.getValue();
//	        hand.add(c);
//	      }
//	      printHandAndValue(hand, totalValue);
//	    }
//	    catch (InputMismatchException e) {
//	      System.out.println("That is not a valid number of cards.");
//	    }
//	    finally {
//	      sc.close();
//	    }
//	  }

//	private void printHandAndValue(List<Card> hand, int value) {
//		for (Card card : hand) {
//			System.out.println(card);
//		}
//		System.out.println("Total value: " + value);
//	}
//
//}
