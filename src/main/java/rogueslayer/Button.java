package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

import java.awt.event.MouseEvent;

public class Button extends SpriteObject implements Clickable {

    private String kindsButton;
    private int mouseX,mouseY;
    private RogueSlayer rs;
    private MainMenu m;
    private int x, y, width, height;
     Button(RogueSlayer rs, int x, int y, int width, int height, String kindsButton){
         super(new Sprite(RogueSlayer.MEDIA_URL.concat(kindsButton +".png")));
         this.kindsButton=kindsButton;
         this.rs = rs;
         this.x=x;
         this.y=y;
         this.width=width;
         this.height=height;
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

        if (kindsButton == "start"){
            if (mouseX > x && mouseX <x+width && mouseY > y &&mouseY < y+height){
                rs.setCurrentScreen(1);
            }
        }

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

        switch (kindsButton){
            case "start":
                System.out.println(mouseCheck(x,y, width, height));
                break;
            case "exit":
                System.out.println(mouseCheck(x,y, width, height));
                break;
            case "menu":
                System.out.println(mouseCheck(x,y, width, height));
                break;

        }
    }

    private String mouseCheck(int x,int y,int width,int height){
         String check;
        if (mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height){
           check = "inside the "+kindsButton+"block";
        }else{ check = "outside the "+kindsButton+"block";}
        return check;
    }
}
