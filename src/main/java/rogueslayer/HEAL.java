package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

public class HEAL extends Card {

	private TextObject tekst;
	private int heal = 20;

	private static String sprite = "healcard";

	protected HEAL(RogueSlayer rs, Player pl, int cardWidth, int cardHeight) {
		super(rs, pl, sprite, cardWidth, cardHeight);
	}

	@Override
	public void doCardEffect() {
		super.doCardEffect();
		pl.hp += heal;
		pl.refreshHP();
	}

	@Override
	public void cardText(RogueSlayer rs) {
		tekst = new TextObject("Heal+"+ heal, 18);
		tekst.setForeColor(255, 0, 0, 255);
		rs.addGameObject(tekst, getX(), getY() + 125);
	}

}
