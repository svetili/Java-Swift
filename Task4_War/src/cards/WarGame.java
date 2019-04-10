package cards;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class WarGame {
	private Queue<Card> player1;
	private Queue<Card> player2;

	public WarGame() {
		this.player1 = new ArrayDeque<Card>();
		this.player2 = new ArrayDeque<Card>();
	}

	public static void initPlayerCards(String line, Queue<Card> player) {
		for (String str : line.split(" ")) {
			char rank = str.charAt(0);
			char suit = str.charAt(1);
			CardRank cardRank = null;
			CardSuit cardSuit = null;
			switch (rank) {
			case '2':
				cardRank = CardRank.Two;
				break;
			case '3':
				cardRank = CardRank.Three;
				break;
			case '4':
				cardRank = CardRank.Four;
				break;
			case '5':
				cardRank = CardRank.Five;
				break;
			case '6':
				cardRank = CardRank.Six;
				break;
			case '7':
				cardRank = CardRank.Seven;
				break;
			case '8':
				cardRank = CardRank.Eight;
				break;
			case '9':
				cardRank = CardRank.Nine;
				break;
			case 'T':
				cardRank = CardRank.Ten;
				break;
			case 'J':
				cardRank = CardRank.Jack;
				break;
			case 'Q':
				cardRank = CardRank.Queen;
				break;
			case 'K':
				cardRank = CardRank.King;
				break;
			case 'A':
				cardRank = CardRank.Ace;
				break;
			}

			switch (suit) {
			case 'c':
				cardSuit = CardSuit.Clubs;
				break;
			case 'd':
				cardSuit = CardSuit.Diamonds;
				break;
			case 'h':
				cardSuit = CardSuit.Hearts;
				break;
			case 's':
				cardSuit = CardSuit.Spades;
				break;
			}
			Card card = new Card(cardRank, cardSuit);
			player.add(card);
		}
	}

	public void readInitInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of cards per player(<26):");
		int cardNumber = sc.nextInt();
		if (cardNumber > 26 || cardNumber < 1) {
			System.out.println("Wrong number!");
			sc.close();
			return;
		}
		sc.nextLine();
		String line1 = sc.nextLine();
		String line2 = sc.nextLine();
		initPlayerCards(line1, player1);
		initPlayerCards(line2, player2);
		sc.close();
	}

	public void playWar(Queue<Card> cardP1, Queue<Card> cardP2) {
		int sum1 = 0, sum2 = 0;
		Queue<Card> tempCards1 = new ArrayDeque<Card>();
		Queue<Card> tempCards2 = new ArrayDeque<Card>();
		for (byte i = 0; i < 3; i++) {
			Card cardTmp1, cardTmp2;
			if (!player1.isEmpty()) {
				cardTmp1 = player1.poll();
				sum1 += cardTmp1.getCardRank().getValue();
				tempCards1.add(cardTmp1);
			}
			if (!player2.isEmpty()) {
				cardTmp2 = player2.poll();
				sum2 += cardTmp2.getCardRank().getValue();
				tempCards2.add(cardTmp2);
			}
		}
		if (sum1 > sum2) {
			player1.addAll(cardP1);
			player1.addAll(cardP2);
			player1.addAll(tempCards1);
			player1.addAll(tempCards2);
		} else if (sum1 < sum2) {
			player2.addAll(cardP2);
			player2.addAll(cardP1);
			player2.addAll(tempCards2);
			player2.addAll(tempCards1);
		} else {
			cardP1.addAll(tempCards1);
			cardP2.addAll(tempCards2);
			if (!player1.isEmpty() || !player2.isEmpty()) {
				playWar(cardP1, cardP2);
			}
		}
	}

	public void playRound() {
		Card cardP1 = player1.poll();
		Card cardP2 = player2.poll();
		if (cardP1.compareTo(cardP2) > 0) {
			player1.add(cardP1);
			player1.add(cardP2);
		} else if (cardP1.compareTo(cardP2) < 0) {
			player2.add(cardP2);
			player2.add(cardP1);
		} else {
			Queue<Card> tempCards1 = new ArrayDeque<Card>();
			tempCards1.add(cardP1);
			Queue<Card> tempCards2 = new ArrayDeque<Card>();
			tempCards2.add(cardP2);
			playWar(tempCards1, tempCards2);
		}

	}

	public static void main(String[] args) {
		WarGame game = new WarGame();
		game.readInitInfo();
		int round = 0;
		while (!game.player1.isEmpty() && !game.player2.isEmpty()) {
			game.playRound();
			round++;
		}

		if (game.player1.isEmpty() && game.player2.isEmpty()) {
			System.out.printf("Game is draw on round %d.\n", round);
		} else if (game.player2.isEmpty()) {
			System.out.printf("Player %d wins on round %d.\n", 1, round);
		} else {
			System.out.printf("Player %d wins on round %d.\n", 2, round);
		}
	}

}
