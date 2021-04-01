package rogueslayer;

public class Enemy extends Entity {

    protected Enemy(RogueSlayer rs, String typeEntity, int maxHP, int maxDEF) {
        super(rs, typeEntity, maxHP, maxDEF);
    }

    @Override
    protected void onDeath(Entity entity) {

    }

    @Override
    public void update() {

    }
}
