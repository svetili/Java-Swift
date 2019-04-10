package deck;

import annotation.CardAnnotation;

@CardAnnotation (type = "enum", category = "CardGames", description = "Contains a set of constants for the suits of a card.")
public enum CardSuit {
	Clubs, Diamonds, Hearts, Spades;
}
