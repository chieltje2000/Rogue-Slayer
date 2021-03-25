package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;


public class ExitButton extends SpriteObject {

    private MainMenu mainMenu;

    public ExitButton(MainMenu mainMenu) {
        super(new Sprite(RogueSlayer.MEDIA_URL.concat("exit.png")));
        this.mainMenu = mainMenu;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {

    }
}
