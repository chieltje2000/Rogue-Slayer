package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import java.awt.event.MouseEvent;

public abstract class Card extends SpriteObject implements Clickable {

	private int cost;
	private int width, height;
	private int mouseX, mouseY;
	Player pl;
	Entity entity;

	Card( Player pl, String cardType, int width, int height) {
		super(new Sprite(RogueSlayer.MEDIA_URL.concat(cardType + ".png")));
		this.pl= pl;
		this.width = width;
		this.height = height;
	}

	public void doCardEffect() {
		pl.cardToDiscard = this;
	}

	public abstract void cardText(RogueSlayer rs);

	@Override
	public void onClick(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();

		if (cardCheck()) {
			doCardEffect();
		}
	}

	@Override
	public void onHover(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();

		if (cardCheck()) {
		}
	}

	private boolean cardCheck() {
		if (mouseX > this.getX() && mouseX < this.getX() + width && mouseY > this.getY()
				&& mouseY < this.getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void update() {
		
	}
}
