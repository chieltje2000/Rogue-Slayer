package rogueslayer;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Button extends SpriteObject implements Clickable {
    private int x, y, width, height;
    private String kindsButton;

     Button(int x,int y ,int width, int height, String kindsButton){
        super(new Sprite(RogueSlayer.MEDIA_URL.concat("button.jpg")));
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.kindsButton=kindsButton;
    }

    public void drawButton(RogueSlayer rs){
        rs.fill(255);
        rs.rect(x,y,width,height);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {

    }
}
