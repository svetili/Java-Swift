package cards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Deck {
	List<Card> deck;
	

	public Deck() {
		this.deck = new ArrayList<Card>();
		for(CardSuit suit: CardSuit.values()) {
			for(CardRank rank: CardRank.values()) {
				Card card = new Card(rank, suit);
				deck.add(card);
			}
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		Iterator<Card> iter = deck.iterator();
		while(iter.hasNext()) {
			s+=iter.next() + "\n";
		}
		return s;
	}


	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck);
	}

}
