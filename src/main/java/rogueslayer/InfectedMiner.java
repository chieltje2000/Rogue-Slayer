package rogueslayer;

public class InfectedMiner extends Enemy {
	private static String sprite = "infectedMiner";

	protected InfectedMiner(RogueSlayer rs, int maxHP, int maxDEF, int x, int y, int attack) {
		super(sprite, rs, maxHP, maxDEF, x, y, attack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void special() {
		hp *= 2;
		refreshHP();
	}
}
