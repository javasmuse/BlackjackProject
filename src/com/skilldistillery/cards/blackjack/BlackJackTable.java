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

	Deck deck = new Deck();

	private boolean keepPlaying = true;

//		do {
//		System.out.println("How old are ya kid?");
//		int age = kb.nextInt();
//		if (age < 21) {
//			System.out.println("Sorry kid the video game arcade is across the street.");
//			keepPlaying = false;
//		}
//		} while (keepPlaying); 

	public void welcome() {
		System.out.println("Welcome to the Beau Rivage BlackJack Table"); // maybe insert some ascii cards
		System.out.println("What's your name?");
		input = kb.next();
		System.out.println("Hello, " + input + " Have a seat.");
		Player you = new Player(input, 31);
		deal();
//  ---- How to return and input the object person? 
	}

	public void deal() {

		System.out.println("Shall I deal you in? press 1 for yes / or 2 to quit");
		int input = kb.nextInt();

		switch (input) {
		case 2:
			System.out.println("Goodbye");
			break;

		case 1:

			if (deck.checkDeckSize() < 20 || deck.checkDeckSize() == 52)
				deck.shuffleCard();

			one.getHand().addCard(deck.dealCard());
			System.out.println(one.toString());

			bob.getHand().addCard(deck.dealCard());

			one.getHand().addCard(deck.dealCard());
			System.out.println(one.toString());
			System.out.println(bob.toString());

			bob.getHand().addCard(deck.dealCard());

			hitOrStay();
		}
	}

//	public void checkBlackJack() {
//
//		if (one.getHand().isBlackJack() == true)
//			System.out.println("Black Jack");
//		else 
//		System.out.println("Nice, let's check the dealer's hand\n");
//		dealersHand(); 
//	}
//	
//	public void dealersHand() { 
//		if (bob.getHand().getHandValue() >= one.getHand().getHandValue())
//			System.out.println("Nice hand, but dealer push (tie - money stays on the table)");
//		else 
//		System.out.println("You win!! ");
//		deal(); 
//	}

	public void hitOrStay() {

		System.out.println("\nYour card total is: " + one.getHand().getHandValue());
		if (one.getHand().isBust() == true)
			System.out.println("Busted!");
		else
			System.out.println("Interesting cards mate, wanna hit? \n Press 1 to hit or 2 to stay.");
		int choice = kb.nextInt();

		if (choice == 1)
			hitMe();
		else
			System.out.println("Player stays");
		standOnDealerPlay();
	}

	public void hitMe() {
		one.getHand().addCard(deck.dealCard());
		System.out.println(one.toString());
		System.out.println("Your new total is: " + one.getHand().getHandValue());
		if (one.getHand().isBust())
			System.out.println("BUSTED!");
		else
			hitOrStay();
	}

	public void standOnDealerPlay() {
		System.out.println("Dealer's Cards: " + bob.toString());
		if (bob.getHand().getHandValue() <= 16)
			bob.getHand().addCard(deck.dealCard());
		else if (bob.getHand().getHandValue() == 21)
			System.out.println("Dealer wins");

		else if (bob.getHand().getHandValue() >= 17)
			compareHands();

	}

	public void compareHands() {

		if (bob.getHand().getHandValue() >= one.getHand().getHandValue())
			System.out.println("Dealer wins");
		else if (one.getHand().getHandValue() > bob.getHand().getHandValue())
			System.out.println("You win! Don't spend it all in one place.");
		deal();
	}

}

//		 add players hand up
//		 check for 21 or bust 

//		System.out.println(deck.checkDeckSize());

//		
//		 keepPlaying = false; 
//		 if 21 - 
//			get dealers hand and compare
//		 		if dealers had == 21 - push 
//		 		else if players hand is greater BLACKJACK! 
//				either case - tie or win - wanna play another hand? 
//					yes (remove played cards from deck //maybe do while at line 43 return to there if yes and quitting (returning to main if no)) 

//
//		bob.getHand().addCard(deck.dealCard());
//	}
//
//
//}

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
