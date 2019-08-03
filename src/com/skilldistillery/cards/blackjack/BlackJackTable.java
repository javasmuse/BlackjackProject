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
			
			one.getHand().clear();
			bob.getHand().clear();
			System.out.println("Cards left, incase your counting: " + deck.checkDeckSize() + "\n");

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
		 
		while (one.getHand().isBust() == true) {
			System.out.println("Busted!\n"); 
			deal();
		 }
			  
		
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
		System.out.println("Dealer's Cards: " + bob.toString() + "\n");
		
		do { 
			
		if (bob.getHand().getHandValue() <= 16)
			bob.getHand().addCard(deck.dealCard());
		
		else if (bob.getHand().getHandValue() >= 22)
			System.out.println("\nDealer Busts --- You win!\n");
		
		else if (bob.getHand().getHandValue() == 21)
			System.out.println("Dealer wins");
		
		else if (bob.getHand().getHandValue() >= 17)
		compareHands();
		
		} while (bob.getHand().getHandValue() <= 21); 
		
		deal(); 
		

	}

	public void compareHands() {

		if (bob.getHand().getHandValue() >= one.getHand().getHandValue())
			System.out.println("\nDealer wins\n with total of " + bob.getHand().getHandValue() + "\n");
		
		else if (one.getHand().getHandValue() > bob.getHand().getHandValue())
			System.out.println("\nYou win! Don't spend it all in one place.\n");
		
		System.out.println(bob.toString() + "\n");
		deal();
	}

}
