package com.skilldistillery.cards.blackjack;

public abstract class Person {

	private String name;
	
	public Person() { 
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "This is " + name;
	}

}