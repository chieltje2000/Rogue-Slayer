package rogueslayer;


import nl.han.ica.oopg.objects.TextObject;

public class ATK extends Card{

    Enemy enemy;
    private TextObject tekst;
    private int damage = 10;

    protected ATK(RogueSlayer rs,Enemy enemy, int cardWidth, int cardHeight) {
        super(rs,"atkcard",cardWidth, cardHeight);
        this.enemy = enemy;
    }

    @Override
    public void doCardEffect() {
        enemy.takeDamage(damage);
    }

    @Override
    public void cardText(RogueSlayer rs){
        tekst = new TextObject("ATK+ 10",18);
        tekst.setForeColor(255,0,0,255);
        rs.addGameObject(tekst,getX(),getY()+125);
    }

    @Override
    public void update() {

    }
}
