package rogueslayer;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Player extends Entity {

	private ArrayList<Card> deck = new ArrayList<Card>();
	private int energy;
	private int handSize = 5;
	private int deckSize = 40;
	private ArrayList<Card> hand = new ArrayList<Card>();
	public Card cardToDiscard = null;
	private ArrayList<Card> discardPile = new ArrayList<Card>();
	private static String sprite = "hero";
	Enemy enemy;
	private int cardWidth = 120;
	private int cardHeight = 191;
	Dialog dl;

	public Player(RogueSlayer rs, int x, int y) {
		super(sprite, rs, 50, 50, x, y);
	}

	public void drawCard() {
		Random random = new Random();
		int randomNumber = random.nextInt(deckSize);

		hand.add(deck.get(randomNumber));
		deck.remove(randomNumber);
		deckSize -= 1;
		
	}

	public void discardCard(Card card) {
		removeHand();
		int index = hand.indexOf(card);
		Card cardToDiscard = hand.get(index);
		discardPile.add(cardToDiscard);
		hand.set(index, getNewCard());
		
		resetHand();
	}

	public void resetDeck() {
		 ArrayList<Card> resetDeck = new ArrayList<Card>();
		for (Card card : deck) {
			resetDeck.add(card);
		}
		for (Card card: discardPile) {
			resetDeck.add(card);
		}
		discardPile.clear();
		System.out.println(discardPile.size());
	}
	
	private Card getNewCard() {
		Card card = null;
		Random random = new Random();
		int randomNumber = random.nextInt(4);
		if (randomNumber == 0) {
			card = new ATK(rs, this, enemy, cardWidth, cardHeight);
		} else if (randomNumber == 1) {
			card = new DEF(rs, this, cardWidth, cardHeight);
		} else if (randomNumber == 2 || randomNumber == 3) {
			card = new HEAL(rs, this, cardWidth, cardHeight);
		}
		
		return card;
	}
	
	public void reward() {
		deck.add(getNewCard());
		
	}
	
	public void enemyChanged(Enemy enemy) {
		for (Card card : hand) {
			if (card instanceof ATK) {
				this.enemy = enemy;
				((ATK) card).enemy = enemy;
			}
		}
		for (Card card : deck) {
			if (card instanceof ATK) {
				this.enemy = enemy;
				((ATK) card).enemy = enemy;
			}
		}
		for (Card card : discardPile) {
			if (card instanceof ATK) {
				this.enemy = enemy;
				((ATK) card).enemy = enemy;
			}
		}
	}

	protected void generateDeck() {

		for (int i = 0; i < deckSize; i++) {
			deck.add(getNewCard());
		}
	}

	private void generateHand() {

		for (int i = 0; i < handSize; i++) {
			drawCard();
		}
	}

	public void onClick(MouseEvent e) {
		for (Card i : hand) {
			i.onClick(e);
		}
		if(cardToDiscard != null) {
			discardCard(cardToDiscard);
		}
	}

	public void onHover(MouseEvent e) {
		for (Card i : hand) {
			i.onHover(e);
		}
	}

	private void removeHand() {
		for (Card card : hand) {
			rs.deleteGameObject(card);
		}
	}
	public void resetHand() {

		for (int i = 0; i < handSize; i++) {
			rs.addGameObject(hand.get(i), i * 150 + 275, 500);
			hand.get(i).cardText(rs);
		}
		
	}

	@Override
	protected void addAllGameObjects() {
		super.addAllGameObjects();
		generateDeck();
		generateHand();
		resetHand();
	}
}
