package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

public abstract class Enemy extends Entity {
	private int attack;
	private TextObject attackCount;
	private TextObject bossText;
	private boolean boss = false;
	

	protected Enemy(String sprite, RogueSlayer rs, int maxHP, int maxDEF, int x, int y, int attack) {
		super(sprite, rs, maxHP, maxDEF, x, y);
		this.attack = attack;
	}

	public abstract void special();
	

	private void drawAtack() {
		attackCount = new TextObject("attack:"+ attack, 20);
		attackCount.setForeColor(0, 0, 255, 255);
		rs.addGameObject(attackCount, getX(), getY() - 100);
	}

	@Override
	protected void addAllGameObjects() {
		// TODO Auto-generated method stub
		super.addAllGameObjects();
		drawAtack();
	}
	@Override
	protected void removeAllGameObjects() {
		// TODO Auto-generated method stub
		super.removeAllGameObjects();
		rs.deleteGameObject(attackCount);
		if(boss) {
			rs.deleteGameObject(bossText);
		}
	}
	
	public void bossMode()
	{
		boss = true;
		bossText = new TextObject("BOSS", 20);
		bossText.setForeColor(0, 0, 255, 255);
		hp *= 2;
		def *= 2;
		rs.addGameObject(bossText, getX(), getY() - 150);
	}
	
	public void doDamage(Player player) {
		player.takeDamage(attack);
	}
}
