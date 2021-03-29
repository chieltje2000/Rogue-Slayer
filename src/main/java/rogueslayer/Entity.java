package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public abstract class Entity extends SpriteObject {
    protected int hp;
    protected int def;
    protected int x;
    protected int y;

    /**
     * Create a new SpriteObject with a Sprite object.
     *
     * @param sprite The sprite
     */

    protected Entity(Sprite sprite, int hp,int def,int x, int y) {
        super(sprite);
        this.hp = hp;
        this.def = def;
        this.x = x;
        this.y = y;
    }

    //private abstract void onDeath();

    private void takeDamage(int damage){}

    private void drawHP(int x, int y){}

    private void drawDEF(int x, int y){}
}
