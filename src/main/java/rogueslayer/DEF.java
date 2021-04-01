package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

public class DEF extends Card{

    private TextObject tekst;
    private int defense = 12;
    Player pl;

    protected DEF(RogueSlayer rs,Player pl, int cardWidth, int cardHeight) {
        super(rs,"defcard",cardWidth, cardHeight);
        this.pl = pl;
    }


    @Override
    public void doCardEffect() {
        pl.def += defense;
    }

    @Override
    public void cardText(RogueSlayer rs) {
        tekst = new TextObject("Defense+12",18);
        tekst.setForeColor(255,0,0,255);
        rs.addGameObject(tekst,getX(),getY()+125);
    }

    @Override
    public void update() {

    }
}
