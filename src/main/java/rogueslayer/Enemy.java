package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

public abstract class Enemy extends Entity {
	private int attack;
	private TextObject attackCount;

	protected Enemy(String sprite, RogueSlayer rs, int maxHP, int maxDEF, int x, int y, int attack) {
		super(sprite, rs, maxHP, maxDEF, x, y);
		this.attack = attack;
	}

	@Override
	protected void onDeath(Player player) {
		player.getNewCard();
	}
	
	public void atack(Player player) {
		player.takeDamage(attack);
	}

	public abstract void special();
	
	@Override
	public void onDeath() {

	}

	@Override
	public void update() {

	}

	private void drawDEF() {
		attackCount = new TextObject(Integer.toString(def), 20);
		attackCount.setForeColor(0, 0, 255, 255);
		rs.addGameObject(attackCount, getX(), getY() - 100);
		attackCount.setText("attack:"+ attack);
	}

	@Override
	protected void addAllGameObjects() {
		// TODO Auto-generated method stub
		super.addAllGameObjects();
		drawDEF();
	}
	@Override
	protected void removeAllGameObjects() {
		// TODO Auto-generated method stub
		super.removeAllGameObjects();
		rs.deleteGameObject(attackCount);
	}

}
