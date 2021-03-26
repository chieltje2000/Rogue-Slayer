package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

import java.awt.event.MouseEvent;

public class Button extends SpriteObject implements Clickable {

    private String kindsButton;
    private int mouseX,mouseY;
    private RogueSlayer rs;
    private MainMenu m;

     Button(RogueSlayer rs, String kindsButton){
         super(new Sprite(RogueSlayer.MEDIA_URL.concat(kindsButton +".png")));
         this.kindsButton=kindsButton;
         this.rs = rs;
    }

    @Override
    public void update() {

    }


    @Override
    public void onClick(MouseEvent e) {
         //haalt X en Y coordinaten bij in console
        mouseX = e.getX();
        mouseY = e.getY();
        System.out.println("mouseX: "+mouseX);
        System.out.println("mouseY: "+mouseY);

        //wanneer muis binnen coordinaten is, voer meegegeven functie uit
       if (mouseX > 565 && mouseX <708 && mouseY > 400 &&mouseY < 475){
           if (kindsButton == "start"){
               rs.setCurrentScreen(1);
           }
           System.out.println("inside the "+kindsButton+"block");
       }else{System.out.println("outside the "+kindsButton+"block");}

        if (mouseX > 565 && mouseX <708 && mouseY > 500 &&mouseY < 575){
            if (kindsButton == "exit"){
                System.exit(0);
            }
        }
    }

    @Override
    public void onHover(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if (mouseX > 565 && mouseX <708 && mouseY > 400 &&mouseY < 475){
            System.out.println("inside the "+kindsButton+"block");
        }else{System.out.println("outside the "+kindsButton+"block");}
    }
}
