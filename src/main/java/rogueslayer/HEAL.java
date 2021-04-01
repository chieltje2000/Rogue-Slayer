package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;

public class HEAL extends Card{

    private String sprite;
    private int heal = 10 ;

    protected HEAL(RogueSlayer rs) {
        super(new Sprite(RogueSlayer.MEDIA_URL.concat("heal.png")),rs);
    }


    @Override
    public void doCardEffect(Entity entity) {
        entity.hp += heal;
    }

    @Override
    public void drawCard() {

    }

    @Override
    public void update() {

    }
}
