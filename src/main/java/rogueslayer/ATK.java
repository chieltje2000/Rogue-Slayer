package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;

public class ATK extends Card{

    private String sprite;
    private int damage = 10;

    protected ATK(RogueSlayer rs) {
        super(new Sprite(RogueSlayer.MEDIA_URL.concat("atk.png")),rs);
    }


    @Override
    public void doCardEffect(Entity entity) {
        entity.takeDamage(10);
    }

    @Override
    public void drawCard() {

    }

    @Override
    public void update() {

    }
}
