package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.objects.TextObject;

public abstract class Entity extends SpriteObject {

	protected int hp = 10;
	protected int maxHP = 10;
	protected int def = 10;
	protected int maxDEF = 10;
	protected int x;
	protected int y;
	protected RogueSlayer rs;
	private TextObject hpCount;
	private TextObject defCount;

	/**
	 * Create a new SpriteObject with a Sprite object.
	 *
	 * @param sprite The sprite
	 */

	protected Entity(String sprite, RogueSlayer rs, int maxHP, int maxDEF, int x, int y) {
		super(new Sprite(RogueSlayer.MEDIA_URL.concat(sprite + ".png")));
		this.rs = rs;
		this.maxHP = maxHP;
		this.hp = maxHP;
		this.maxDEF = maxDEF;
		this.def = maxDEF;
		this.x = x;
		this.y = y;
	}

	protected abstract void onDeath();

	protected abstract void onDeath(Player player);

	protected void takeDamage(int damage) {
		int restDamage = 0;
		def -= damage;
		refreshDEF();
		if (def < 0) {
			restDamage = def * -1;
			def = 0;
			refreshDEF();
		}

		hp -= restDamage;
		refreshHP();
		if (hp <= 0) {
			hp = 0;
			onDeath();
		}
	}

	private void drawHP() {
		hpCount = new TextObject(Integer.toString(hp), 20);
		hpCount.setForeColor(255, 0, 0, 255);
		rs.addGameObject(hpCount, getX(), getY() - 75);
		hpCount.setText("HP: " + hp + "/" + maxHP);
	}

	private void drawDEF() {
		defCount = new TextObject(Integer.toString(def), 20);
		defCount.setForeColor(0, 0, 255, 255);
		rs.addGameObject(defCount, getX(), getY() - 50);
		defCount.setText("DEF: " + def + "/" + maxDEF);
	}

	protected void addAllGameObjects() {
		rs.addGameObject(this, x, y);
		drawHP();
		drawDEF();
	}

	protected void removeAllGameObjects() {
		rs.deleteGameObject(defCount);
		rs.deleteGameObject(hpCount);
		rs.deleteGameObject(this);
	}

	protected void refreshHP() {
		hpCount.setText("HP: " + hp + "/" + maxHP);
	}

	protected void refreshDEF() {
		defCount.setText("DEF: " + def + "/" + maxDEF);
	}

}
