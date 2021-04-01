package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

public class HEAL extends Card{

    private TextObject tekst;
    private int heal = 10 ;
    Player pl;

    protected HEAL(RogueSlayer rs, Player pl,int cardWidth, int cardHeight) {
        super(rs,"healcard",cardWidth, cardHeight);
        this.pl = pl;
    }


    @Override
    public void doCardEffect() {
        pl.hp += heal;
    }

    @Override
    public void cardText(RogueSlayer rs){
        tekst = new TextObject("Heal+10",18);
        tekst.setForeColor(255,0,0,255);
        rs.addGameObject(tekst,getX(),getY()+125);
    }

    @Override
    public void update() {

    }
}
