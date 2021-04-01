package rogueslayer;

import java.util.ArrayList;

public class Player extends Entity {

	private ArrayList<Card> deck = new ArrayList<Card>();
	private int energy;
	private int handSize;
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> discardPile = new ArrayList<Card>();
	private static String sprite = "hero";

	public Player(RogueSlayer rs, int x, int y) {
		super(sprite, rs, 50, 50, x, y);
	}

	@Override
	public void update() {

	}

	@Override
	protected void onDeath(Player player) {

	}

	public void drawCard() {

	}

	public void useCard() {

	}

	public void discardCard() {

	}

	public void getNewCard() {

	}

	@Override
	protected void onDeath() {
		// TODO Auto-generated method stub

	}

}
