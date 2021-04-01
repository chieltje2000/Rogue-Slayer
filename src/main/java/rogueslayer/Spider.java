package rogueslayer;

public class Spider extends Enemy {
	private static String sprite = "spider";

	protected Spider(RogueSlayer rs, int maxHP, int maxDEF, int x, int y, int attack) {
		super(sprite, rs, maxHP, maxDEF, x, y, attack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void special() {
		def *= 2;
		refreshDEF();
	}
}
