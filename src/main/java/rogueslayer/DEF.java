package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

public class DEF extends Card {

	private TextObject tekst;
	private int defense = 15;
	private static String sprite = "defcard";

	protected DEF( Player pl, int cardWidth, int cardHeight) {
		super(pl, sprite, cardWidth, cardHeight);
	}

	@Override
	public void doCardEffect() {
		super.doCardEffect();
		pl.def += defense;
		pl.refreshDEF();
	}

	@Override
	public void cardText(RogueSlayer rs) {
		tekst = new TextObject("Defense+"+defense, 18);
		tekst.setForeColor(255, 0, 0, 255);
		rs.addGameObject(tekst, getX(), getY() + 125);
	}

}
