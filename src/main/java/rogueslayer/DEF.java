package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;

public class DEF extends Card{

    private String sprite;
    private int defense = 12;

    protected DEF(RogueSlayer rs) {
        super(new Sprite(RogueSlayer.MEDIA_URL.concat("def.png")),rs);
    }


    @Override
    public void doCardEffect(Entity entity) {
        entity.def += defense;
    }

    @Override
    public void drawCard() {

    }

    @Override
    public void update() {

    }
}
