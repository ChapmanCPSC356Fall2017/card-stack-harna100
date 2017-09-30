package edu.chapman.cpsc356.harna100.cardstack;

/**
 * Created by Paul on 9/29/2017.
 */

public class CardModel {
	private Suit suit;
	private String value;

	public CardModel(Suit suit, String value) {
		this.suit = suit;
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public String getValue() {
		return value;
	}


}
