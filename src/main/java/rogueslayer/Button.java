package rogueslayer;

import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

import java.awt.event.MouseEvent;

public class Button extends SpriteObject implements Clickable {

    private String kindsButton;
    private int mouseX,mouseY;
    private RogueSlayer rs;
    private int x, y, width, height;
    private Dialog dl;
    private Card card;

    //button
     Button(RogueSlayer rs, int x, int y, int width, int height, String kindsButton){
         super(new Sprite(RogueSlayer.MEDIA_URL.concat(kindsButton +".png")));
         this.kindsButton=kindsButton;
         this.rs = rs;
         this.x=x;
         this.y=y;
         this.width=width;
         this.height=height;
    }
    //dialog
    Button(RogueSlayer rs, int x, int y, int width, int height, String kindsButton, Dialog dl){
        this(rs, x, y, width, height, kindsButton);
        this.dl = dl;
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


        switch (kindsButton){
            case "start":
                if (mouseCheck(x,y, width, height)){
                    rs.setCurrentScreen(1);
                }
                break;
            case "exit":
                if (mouseCheck(x,y, width, height)){
                    System.exit(0);
                }
                break;
            case "menu":
                if (mouseCheck(x,y, width, height)){
                    rs.setCurrentScreen(0);
                }
                break;
            case "dialog":
                if (mouseCheck(x,y, width, height)){
                    System.out.println("dialog");
                dl.removeText();
                }
                break;
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

    private boolean mouseCheck(int x,int y,int width,int height){
        if (mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height){
          return true;
        }else{ return false;}
    }
}
