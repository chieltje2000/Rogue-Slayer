package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import java.awt.event.MouseEvent;

public abstract class Card extends SpriteObject implements Clickable{

    private RogueSlayer rs;
    private int cost;
    private String cardType;
    private int width, height;
    private int mouseX,mouseY;

    protected Card(RogueSlayer rs, String cardType,int width, int height){
        super(new Sprite(RogueSlayer.MEDIA_URL.concat(cardType +".png")));
        this.rs= rs;
        this.cardType = cardType;
        this.width=width;
        this.height=height;
    }

    public abstract void doCardEffect();

    public abstract void cardText(RogueSlayer rs);

    @Override
    public void onClick(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();

              if ( cardCheck()){
                  doCardEffect();
                }
    }

    @Override
    public void onHover(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        switch (cardType){
            case "atkcard":
                if ( cardCheck()){
                    System.out.println("dit is een atk card");
                }
                break;
            case "defcard":
                if ( cardCheck()){
                    System.out.println("dit is een def card");
                }
                break;
            case "healcard":
                if ( cardCheck()){
                    System.out.println("dit is een heal card");
                }
                break;
        }
    }

    private boolean cardCheck(){
        if (mouseX > this.getX() && mouseX < this.getX() + width && mouseY > this.getY() && mouseY < this.getY() + height){
            return true;
        }else{ return false;}
    }
}
