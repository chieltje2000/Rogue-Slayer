package rogueslayer;

<<<<<<< HEAD
public class Golem extends Enemy {
	private static String sprite = "golem";

	protected Golem(RogueSlayer rs, int maxHP, int maxDEF,int x, int y, int attack) {
		super(sprite, rs, maxHP, maxDEF,x,y,attack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void special() {
		hp *= 2;
		def *= 2;
		refreshDEF();
		refreshHP();
	}


=======
public class   Golem extends Enemy {
>>>>>>> master

    protected Golem(RogueSlayer rs, String typeEntity, int maxHP, int maxDEF) {
        super(rs, typeEntity, maxHP, maxDEF);
    }
}
