package com.skilldistillery.cards.blackjack;

public class BlackJackApp {

	public BlackJackApp() {
	}
	
	BlackJackTable table = new BlackJackTable(); 

	public static void main(String[] args) {
		BlackJackApp bja = new BlackJackApp();
		bja.runMe();

	}
	
	public void runMe() {
		table.welcome();
		
	
		// call to the Table 
		// do hand logic in the BlackJackHand
	}

}
