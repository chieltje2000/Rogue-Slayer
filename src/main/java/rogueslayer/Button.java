package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import sun.applet.Main;

import java.awt.event.MouseEvent;

public class Button extends SpriteObject implements Clickable {

    private String kindsButton;
    private int mouseX,mouseY;
    private RogueSlayer rs;
    private ExitButton b;
    private MainMenu m;

     Button(String kindsButton){
         super(new Sprite(RogueSlayer.MEDIA_URL.concat("start.png")));
         this.kindsButton=kindsButton;
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
               System.out.println("button type: " + kindsButton);
           }
           System.out.println("inside the startblock");
       }else{System.out.println("outside the startblock");}

        if (mouseX > 565 && mouseX <708 && mouseY > 500 &&mouseY < 575){
            kindsButton = "exit";
            if (kindsButton == "exit"){
                //rs.setCurrentScreen(1);
                System.out.println("button type: " + kindsButton);
            }
            System.out.println("inside the exitblock");
        }else{System.out.println("outside the exitblock");}
    }

    @Override
    public void onHover(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        System.out.println("mouseX: "+mouseX);
        System.out.println("mouseY: "+mouseY);
    }
}
