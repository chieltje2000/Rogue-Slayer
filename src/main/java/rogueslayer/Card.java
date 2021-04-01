package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.objects.TextObject;

public abstract class Card extends SpriteObject {

    private RogueSlayer rs;
    private int cost;
    private TextObject text;
    private String sprite;

    protected Card(Sprite sprite,RogueSlayer rs){
        super(sprite);
        this.rs= rs;
    }

    public abstract void doCardEffect(Entity entity);

    public abstract void drawCard();
}
