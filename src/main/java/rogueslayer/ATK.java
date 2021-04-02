package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

public class ATK extends Card {

	public Enemy enemy;
	private TextObject tekst;
	private int damage = 20;
	private static String sprite = "atkcard";

	ATK(Player pl, Enemy enemy, int cardWidth, int cardHeight) {
		super(pl, sprite, cardWidth, cardHeight);
		this.enemy = enemy;
	}

	@Override
	public void doCardEffect() {
		super.doCardEffect();
		enemy.takeDamage(damage);
	}

	@Override
	public void cardText(RogueSlayer rs) {
		tekst = new TextObject("ATK+"+damage, 18);
		tekst.setForeColor(255, 0, 0, 255);
		rs.addGameObject(tekst, getX(), getY() + 125);
	}

}
