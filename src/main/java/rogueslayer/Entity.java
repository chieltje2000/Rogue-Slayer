package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.objects.TextObject;

public abstract class Entity extends SpriteObject {

    protected int hp = 10;
    protected int maxHP = 10;
    protected int def = 10;
    protected int maxDEF = 10;
    protected int x;
    protected int y;
    protected RogueSlayer rs;
    private TextObject hpCount;
    private TextObject defCount;

    /**
     * Create a new SpriteObject with a Sprite object.
     *
     * @param sprite The sprite
     */

    protected Entity(Sprite sprite,RogueSlayer rs,int maxHP,int maxDEF) {
        super(sprite);
        this.rs = rs;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.maxDEF = maxDEF;
        this.def = maxDEF;

    }

    protected abstract void onDeath();

    protected void takeDamage(int damage){
        int restDamage = 0;
        def -= damage;
        refreshDEF();
        if (def < 0){
            restDamage = def *-1;
            def =0;
            refreshDEF();
        }
        
        hp -= restDamage;
        refreshHP();
        if (hp<0){
            hp = 0;
            refreshHP();
            onDeath();
        }
    }

    protected void drawHP(){
        hpCount = new TextObject(Integer.toString(hp),20);
        hpCount.setForeColor(255,0,0,255);
        rs.addGameObject(hpCount,getX(),getY()-75);
        hpCount.setText("HP: "+hp+"/"+maxHP);
    }

    protected void drawDEF(){
        defCount = new TextObject(Integer.toString(def),20);
        defCount.setForeColor(0,0,255,255);
        rs.addGameObject(defCount,getX(),getY()-50);
        defCount.setText("DEF: "+def+"/"+maxDEF);
    }

    private void refreshHP(){ hpCount.setText("HP: "+hp+"/"+maxHP);
    }

    private void refreshDEF(){
        defCount.setText("DEF: "+def+"/"+maxDEF);
    }
}
