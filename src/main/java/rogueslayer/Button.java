package rogueslayer;


import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Button extends SpriteObject implements Clickable {

    private String kindsButton;
    private int mouseX,mouseY;
    private RogueSlayer rs;
    private String buttons[] = {"start.png","exit.png","menu.png"};

     Button(String kindsButton){
         super(new Sprite(RogueSlayer.MEDIA_URL.concat("start.png")));
         this.kindsButton=kindsButton;
    }


    @Override
    public void update() {

    }


    @Override
    public void onClick(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        System.out.println("mouseX: "+mouseX);
        System.out.println("mouseY: "+mouseY);
       if (mouseX > 565 && mouseX <708 && mouseY > 400 &&mouseY < 475){
           //rs.setCurrentScreen(1);
           System.out.println("inside the block");
       }else{System.out.println("outside the block");}
    }

    @Override
    public void onHover(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        System.out.println("mouseX: "+mouseX);
        System.out.println("mouseY: "+mouseY);
    }
}
