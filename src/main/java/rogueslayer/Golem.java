package rogueslayer;


public class Golem extends Enemy {
	private static String sprite = "golem";

	protected Golem(RogueSlayer rs, int maxHP, int maxDEF,int x, int y, int attack) {
		super(sprite, rs, maxHP, maxDEF,x,y,attack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void special() {
		hp *= 1.5;
		def *= 1.5;
		refreshDEF();
		refreshHP();
	}
}



