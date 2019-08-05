package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackJackTable {

	Scanner kb = new Scanner(System.in);

	Player one = new Player();
	Dealer bob = new Dealer();

	String input;

	Deck deck = new Deck();

	public void welcome() {
		
		System.out.println("$*$*$*$*$*$*Welcome to the Beau Rivage BlackJack Table*$*$*$*$*$*$");
		
		System.out.println("\nWhat's your name?");
		input = kb.next();
		System.out.println("\nHow old are ya kid?");

		int age = kb.nextInt();
		if (age < 21) {
			System.out.println(
					"\nSorry kid, the Video Game Arcade is across the street and to the left of the Candy Shop.\n Goodbye");
		} else if (age > 21) {
			System.out.println("\nHello, " + input + ". Have a seat.");
			deal();
		}
	}

	public void deal() {

		System.out.println("\nShall I deal you in? press 1 for yes / or 0 to quit\n");
		int input = kb.nextInt();

		switch (input) {


		case 1:

			if ((deck.checkDeckSize() <= 20) || (deck.checkDeckSize() == 52)) 
			deck.shuffleCard(); 

			one.getHand().clear();
			bob.getHand().clear();
			System.out.println("\n\n\tCards left, incase your counting: " + deck.checkDeckSize() + "\n");

			one.getHand().addCard(deck.dealCard());
			System.out.println(one.toString());

			bob.getHand().addCard(deck.dealCard());

			one.getHand().addCard(deck.dealCard());
			System.out.println(one.toString());
			System.out.println("\t" + bob.toString());

			bob.getHand().addCard(deck.dealCard());

			if (one.getHand().getHandValue() == 21)
				checkBlackJack();
			else
				hitOrStay();

		case 0:
			System.out.println("Goodbye");
			break;
		}
	}

	public void checkBlackJack() {

		if (one.getHand().isBlackJack() == true) {
			System.out.println("Black Jack");
		}
		System.out.println("Nice, let's check the dealer's hand\n");

		dealersHand();
	}

	public void dealersHand() {
		if (bob.getHand().getHandValue() == one.getHand().getHandValue())
			System.out.println("Nice hand, but dealer push (tie - money stays on the table)");
		else
			System.out.println("You win!! ");
		deal();
	}

	public void hitOrStay() {

		System.out.println("\nYour card total is: " + one.getHand().getHandValue());

		while (one.getHand().isBust() == true) {
			System.out.println("Busted!\n");
			deal();
		}

		System.out.println("\nInteresting cards mate, wanna hit? \n Press 1 to hit or 2 to stay.");
		int choice = kb.nextInt();

		if (choice == 1)
			hitMe();
		else
			standOnDealerPlay();
	}

	public void hitMe() {
		one.getHand().addCard(deck.dealCard());
		System.out.println(one.toString());
		System.out.println("\nYour new total is: " + one.getHand().getHandValue());
		if (one.getHand().isBust())
			System.out.println("\nBUSTED!");

		else
			hitOrStay();
		deal();
	}

	public void standOnDealerPlay() {
		System.out.println("\nPlayer stays");
		System.out.println("\n\nDealer's Cards: " + bob.toString() + "\n");

		do {

			if (bob.getHand().getHandValue() <= 16)
				bob.getHand().addCard(deck.dealCard());
			System.out.println("\t" + bob.toString() + "\n");

		} while (bob.getHand().getHandValue() <= 16);

		if (bob.getHand().getHandValue() >= 22)
			playerWins();

		else if (bob.getHand().getHandValue() == 21)
			compareHands();

		else if (bob.getHand().getHandValue() >= 17)
			compareHands();

	}

	public void playerWins() {
		System.out.println("\nDealer busts - player you win!! \n ");
		deal();
	}

	public void dealerPush() {
		System.out.println("\n Sadly the tie goes to the house - Dealer push\n");
		deal();
	}

	public void compareHands() {

		if (bob.getHand().getHandValue() > one.getHand().getHandValue())
			System.out.println("\nDealer wins\n with total of " + bob.getHand().getHandValue() + "\n");

		else if (bob.getHand().getHandValue() == one.getHand().getHandValue())
			dealerPush();

		else if (one.getHand().getHandValue() > bob.getHand().getHandValue())
			System.out.println("\nYou win! Don't spend it all in one place.\n");

		deal();
	}

}
