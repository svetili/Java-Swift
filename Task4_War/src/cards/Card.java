package cards;


public class Card implements  Comparable<Card>{
	private CardRank cardRank;
	private CardSuit cardSuit;
	
	public Card(CardRank cardRank, CardSuit cardSuit) {
		this.cardRank = cardRank;
		this.cardSuit = cardSuit;
	}
	
	public CardRank getCardRank() {
		return cardRank;
	}

	@Override
	public String toString() {
		return String.format("%s of %s", cardRank, cardSuit);
	}

	@Override
	public int compareTo(Card other) {
		if(this.cardRank.getValue() > other.cardRank.getValue()) {
			return 1;
		} else if (this.cardRank.getValue() < other.cardRank.getValue()) {
			return -1;
		}
		return 0;
	}
	
}
